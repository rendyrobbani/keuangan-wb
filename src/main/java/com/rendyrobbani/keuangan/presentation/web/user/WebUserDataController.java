package com.rendyrobbani.keuangan.presentation.web.user;

import com.rendyrobbani.keuangan.application.web.record.user.RecordOfWebUserDataCreateRequest;
import com.rendyrobbani.keuangan.application.web.record.user.RecordOfWebUserDataUpdateRequest;
import com.rendyrobbani.keuangan.domain.auth.WebAuthorizationService;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.*;
import com.rendyrobbani.keuangan.infrastructure.vo.RoleEnum;
import com.rendyrobbani.keuangan.presentation.web.WebResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WebUserDataController {

	private final WebResponse response;

	private final WebAuthorizationService authorizationService;

	private final WebUserDataSelectService selectService;

	private final WebUserDataCreateService createService;

	private final WebUserDataUpdateService updateService;

	private final WebUserDataDeleteService deleteService;

	private final WebUserDataLockedService lockedService;

	@GetMapping("/web/user")
	public ResponseEntity<?> selectAll() {
		authorizationService.hasInRole(RoleEnum.SEKDA, RoleEnum.PPKD, RoleEnum.TAPD);
		return response.success(selectService.selectAll());
	}

	@GetMapping("/web/user/{id}")
	public ResponseEntity<?> selectById(@PathVariable String id) {
		authorizationService.hasInRole(RoleEnum.SEKDA, RoleEnum.PPKD, RoleEnum.TAPD);
		return response.success(selectService.selectById(id));
	}

	@PostMapping("/web/user")
	public ResponseEntity<?> create(@RequestBody RecordOfWebUserDataCreateRequest request) {
		authorizationService.hasInRole(RoleEnum.PPKD);
		return response.success(createService.create(request));
	}

	@PutMapping("/web/user/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody RecordOfWebUserDataUpdateRequest request) {
		authorizationService.hasInRole(RoleEnum.PPKD);
		return response.success(updateService.update(id, request));
	}

	@DeleteMapping("/web/user/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		authorizationService.hasInRole(RoleEnum.PPKD);
		return response.success(deleteService.delete(id));
	}

	@PostMapping("/web/user/{id}")
	public ResponseEntity<?> revive(@PathVariable String id) {
		authorizationService.hasInRole();
		return response.success(deleteService.revive(id));
	}

}