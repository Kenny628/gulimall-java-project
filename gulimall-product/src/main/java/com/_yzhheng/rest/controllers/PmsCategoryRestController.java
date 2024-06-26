/*
 * Created on 2024-05-02 ( 15:33:59 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._yzhheng.rest.dto.PmsCategoryDTO;
import com._yzhheng.rest.services.PmsCategoryService;

@RestController
@RequestMapping(value = "api/v1/PmsCategory", produces = MediaType.APPLICATION_JSON_VALUE)
public class PmsCategoryRestController {

	private static final Logger logger = LoggerFactory.getLogger(PmsCategoryRestController.class);

	private PmsCategoryService service; // injected

	/**
	 * Constructor (usable for Dependency Injection)
	 *
	 * @param service
	 */
	protected PmsCategoryRestController(PmsCategoryService service) {
		super();
		this.service = service;
	}

	/**
	 * Get ALL
	 *
	 * @return
	 */
	@GetMapping("/listAll")
	protected ResponseEntity<List<PmsCategoryDTO>> listWithTree() {
		logger.debug("REST : GET - listWithTree");
		List<PmsCategoryDTO> list = service.listWithTree();
		return ResponseEntity.ok(list); // always 200
	}

	@GetMapping("")
	protected ResponseEntity<List<PmsCategoryDTO>> findAll() {
		logger.debug("REST : GET - findAll");
		List<PmsCategoryDTO> list = service.findAll();
		return ResponseEntity.ok(list); // always 200
	}

	/**
	 * Get ONE identified by the given PK
	 *
	 * @param catId
	 * @return 200 or 404
	 */
	@GetMapping("/{catId}")
	protected ResponseEntity<PmsCategoryDTO> findById(@PathVariable Long catId) {
		logger.debug("REST : GET - findById");
		PmsCategoryDTO pmsCategoryDTO = service.findById(catId);
		if (pmsCategoryDTO != null) {
			return ResponseEntity.ok(pmsCategoryDTO); // 200 OK, found
		} else {
			return ResponseEntity.notFound().build(); // 404 Not found
		}
	}

	/**
	 * Create if doesn't exist
	 *
	 * @param pmsCategoryDTO
	 * @return 201 created or 409 conflict
	 */
	@PostMapping("")
	protected ResponseEntity<Void> create(@RequestBody PmsCategoryDTO pmsCategoryDTO) {
		logger.debug("REST : POST - create");
		if (service.create(pmsCategoryDTO)) {
			return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 created
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict
		}
	}

	/**
	 * Update or create
	 *
	 * @param catId
	 * @param pmsCategoryDTO
	 * @return 200 updated or created
	 */
	@PutMapping("/{catId}")
	protected ResponseEntity<Void> save(@PathVariable Long catId, @RequestBody PmsCategoryDTO pmsCategoryDTO) {
		logger.debug("REST : PUT - save");
		service.save(catId, pmsCategoryDTO);
		return ResponseEntity.ok().build(); // OK, updated or created
	}

	/**
	 * Update if exists
	 *
	 * @param pmsCategoryDTO
	 * @return 200 updated or 404 not found
	 */
	@PutMapping("")
	protected ResponseEntity<Void> update(@RequestBody PmsCategoryDTO pmsCategoryDTO) {
		logger.debug("REST : PUT - update");
		if (service.update(pmsCategoryDTO)) {
			return ResponseEntity.ok().build(); // 200 OK, found and updated
		} else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not updated"
		}
	}

	/**
	 * Partial update for the given PK (if it exists )
	 *
	 * @param catId
	 * @param pmsCategoryDTO
	 * @return 200 updated or 404 not found
	 */
	@PatchMapping("/{catId}")
	protected ResponseEntity<Void> partialUpdate(@PathVariable Long catId, @RequestBody PmsCategoryDTO pmsCategoryDTO) {
		logger.debug("REST : PATCH - partialUpdate");
		if (service.partialUpdate(catId, pmsCategoryDTO)) {
			return ResponseEntity.ok().build(); // OK, found and updated
		} else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not updated"
		}
	}

	/**
	 * Delete by PK
	 *
	 * @param catId
	 * @return 204 deleted or 404 not found
	 */
	@DeleteMapping("/{catId}")
	protected ResponseEntity<Void> deleteById(@PathVariable Long catId) {
		logger.debug("REST : DELETE - deleteById");
		if (service.deleteById(catId)) {
			return ResponseEntity.noContent().build(); // 204 No content = "deleted"
		} else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not deleted"
		}
	}

}
