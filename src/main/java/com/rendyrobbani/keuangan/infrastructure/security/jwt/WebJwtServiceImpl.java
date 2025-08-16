package com.rendyrobbani.keuangan.infrastructure.security.jwt;

import com.rendyrobbani.keuangan.common.exception.http.UnauthorizedException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtPayload;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Role;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.infrastructure.vo.RoleEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class WebJwtServiceImpl implements WebJwtService {

	private static final String KEY_TAHUN = "tahun";

	private static final String KEY_USER = "userId";

	private static final String KEY_ROLE = "roleId";

	@Value("${com.rendyrobbani.keuangan.tahun}")
	private Integer tahun;

	@Value("${com.rendyrobbani.keuangan.auth.token-expired}")
	private Integer expired;

	@Value("${com.rendyrobbani.keuangan.auth.token-name}")
	private String tokenName;

	private final SecretKey secretKey;

	private final DataUserRepository userRepository;

	@Override
	public String encode(WebJwtPayload payload) {
		return payload == null ? null : Jwts.builder()
				.header()
				.add("alg", "HS256")
				.add("typ", "JWT")
				.and()
				.claim(KEY_TAHUN, this.tahun)
				.claim(KEY_USER, payload.user().id())
				.claim(KEY_ROLE, payload.role() != null ? payload.role().value() : null)
				.expiration(new Date(System.currentTimeMillis() + (1000 * 60 * expired.longValue())))
				.signWith(secretKey)
				.compact();
	}

	@Override
	public WebJwtPayload decode(String token) {
		if (token == null) return null;
		try {
			Claims payload = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
			var tahun = payload.get(KEY_TAHUN, Integer.class);
			if (tahun.intValue() != this.tahun.intValue()) throw new UnauthorizedException();

			var userId = payload.get(KEY_USER, String.class);
			if (userId == null) throw new UnauthorizedException();
			var user = userRepository.selectById(userId);
			if (user == null) throw new UnauthorizedException();

			var roleId = payload.get(KEY_ROLE, Integer.class);
			var role = RoleEnum.fromValue(roleId);

			return new WebJwtPayloadRecord(tahun, user, role);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void setToken(WebJwtPayload payload) {
		SecurityContextHolder.getContext().setAuthentication(payload == null ? null : new UsernamePasswordAuthenticationToken(payload, encode(payload), null));
	}

	@Override
	public void setToken(DataUser user, Role role) {
		this.setToken(new WebJwtPayloadRecord(tahun, user, role));
	}

	@Override
	public void setToken(DataUser user) {
		this.setToken(user, null);
	}

	@Override
	public WebJwtPayload getToken() {
		try {
			Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (o == null) return null;
			return (WebJwtPayload) o;
		} catch (Exception ignored) {
			return null;
		}
	}

	@Override
	public String getTokenAsString() {
		try {
			Object o = SecurityContextHolder.getContext().getAuthentication().getCredentials();
			if (o == null) return null;
			return (String) o;
		} catch (Exception ignored) {
			return null;
		}
	}

	@Override
	public String getTokenAsCookie() {
		var token = getTokenAsString();
		if (token == null) return "";
		return String.join("; ", tokenName + "=" + token, "Path=/", "SameSite=None", "Secure=false");
	}

	@Override
	public DataUser getUser() {
		var payload = getToken();
		if (payload != null) return payload.user();
		return null;
	}

	@Override
	public Role getRole() {
		var payload = getToken();
		if (payload != null) return payload.role();
		return null;
	}

	@Override
	public boolean isAdmin() {
		return this.getRole().equals(RoleEnum.ADMIN);
	}

}