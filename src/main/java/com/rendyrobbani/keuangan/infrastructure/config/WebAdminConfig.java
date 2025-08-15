package com.rendyrobbani.keuangan.infrastructure.config;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.LogsUserRepository;
import com.rendyrobbani.keuangan.infrastructure.vo.NipFactory;
import com.rendyrobbani.keuangan.infrastructure.vo.PangkatEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class WebAdminConfig {

	public static final Nip ADMIN_NIP = NipFactory.create("199510172019031003");

	public static final Pangkat ADMIN_PANGKAT = PangkatEnum.PNS_2C;

	public static final String ADMIN_NAME = "Rendy Robbani";

	public static final String ADMIN_TITLE_PREFIX = null;

	public static final String ADMIN_TITLE_SUFFIX = "A.Md.";

	public static final String ADMIN_PASSWORD = "$2a$12$tw0qm9oRGF0ocsuzdXpwM.4mVolzc7YmZrqwQO7TkiMKTHZgPMLrC";

	private final DataUserRepository dataRepository;

	private final LogsUserRepository logsRepository;

	@Bean
	public DataUser admin() {
		var now = LocalDateTime.now();
		var nip = ADMIN_NIP;

		var data = dataRepository.selectById(nip.simple());
		if (data == null) {
			data = new DataUser() {
				@Override
				public String id() {
					return ADMIN_NIP.simple();
				}

				@Override
				public Nip nip() {
					return ADMIN_NIP;
				}

				@Override
				public Pangkat pangkat() {
					return ADMIN_PANGKAT;
				}

				@Override
				public String name() {
					return ADMIN_NAME;
				}

				@Override
				public String titlePrefix() {
					return ADMIN_TITLE_PREFIX;
				}

				@Override
				public String titleSuffix() {
					return ADMIN_TITLE_SUFFIX;
				}

				@Override
				public String password() {
					return ADMIN_PASSWORD;
				}

				@Override
				public LocalDate dateOfBirth() {
					return ADMIN_NIP.dateOfBirth();
				}

				@Override
				public LocalDate dateOfStart() {
					return ADMIN_NIP.dateOfStart();
				}

				@Override
				public Gender gender() {
					return ADMIN_NIP.gender();
				}

				@Override
				public Integer number() {
					return ADMIN_NIP.number();
				}

				@Override
				public boolean isPNS() {
					return ADMIN_PANGKAT.isPNS();
				}

				@Override
				public boolean isP3K() {
					return ADMIN_PANGKAT.isP3K();
				}

				@Override
				public boolean isLocked() {
					return false;
				}

				@Override
				public boolean isDeleted() {
					return false;
				}
			};
			dataRepository.create(data, now, nip);
			logsRepository.create(data, now, nip);
		}
		return data;
	}

}