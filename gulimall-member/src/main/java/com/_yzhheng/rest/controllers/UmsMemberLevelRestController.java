/*
 * Created on 2024-05-02 ( 16:45:39 )
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

import com._yzhheng.rest.dto.UmsMemberLevelDTO;
import com._yzhheng.rest.services.UmsMemberLevelService;

@RestController
@RequestMapping(value = "api/v1/UmsMemberLevel", produces = MediaType.APPLICATION_JSON_VALUE)
public class UmsMemberLevelRestController {

	private static final Logger logger = LoggerFactory.getLogger(UmsMemberLevelRestController.class);
	
	private UmsMemberLevelService service ; // injected
	
	/**
	 * Constructor (usable for Dependency Injection)
	 *
	 * @param service
	 */
	protected UmsMemberLevelRestController(UmsMemberLevelService service) {
		super();
		this.service = service;
	}
    
	/**
	 * Get ALL
	 *
	 * @return
	 */
	@GetMapping("")
	protected ResponseEntity<List<UmsMemberLevelDTO>> findAll() {
    	logger.debug("REST : GET - findAll");
    	List<UmsMemberLevelDTO> list = service.findAll();
    	return ResponseEntity.ok(list); // always 200
    }
    
    /**
     * Get ONE identified by the given PK
	 *
	 * @param id
     * @return 200 or 404 
     */
    @GetMapping("/{id}")
    protected ResponseEntity<UmsMemberLevelDTO> findById(@PathVariable Long id) {
    	logger.debug("REST : GET - findById");
    	UmsMemberLevelDTO umsMemberLevelDTO = service.findById(id);
		if ( umsMemberLevelDTO != null ) {
			return ResponseEntity.ok(umsMemberLevelDTO); // 200 OK, found
		}
		else {
			return ResponseEntity.notFound().build(); // 404 Not found
		}		
    }

    
	/**
 	 * Create if doesn't exist 
	 *
	 * @param umsMemberLevelDTO
	 * @return 201 created or 409 conflict
	 */
	@PostMapping("")
	protected ResponseEntity<Void> create(@RequestBody UmsMemberLevelDTO umsMemberLevelDTO) {
    	logger.debug("REST : POST - create");
		if ( service.create(umsMemberLevelDTO) ) {
			return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 created
		}
		else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict
		}
	}

	/**
	 * Update or create
	 *
	 * @param id
	 * @param umsMemberLevelDTO
	 * @return 200 updated or created
	 */
	@PutMapping("/{id}")
	protected ResponseEntity<Void> save(@PathVariable Long id, @RequestBody UmsMemberLevelDTO umsMemberLevelDTO) {
    	logger.debug("REST : PUT - save");
		service.save(id, umsMemberLevelDTO);
		return ResponseEntity.ok().build(); // OK, updated or created
	}

	/**
 	 * Update if exists 
	 *
	 * @param umsMemberLevelDTO
	 * @return 200 updated or 404 not found
	 */
	@PutMapping("")
	protected ResponseEntity<Void> update(@RequestBody UmsMemberLevelDTO umsMemberLevelDTO) {
    	logger.debug("REST : PUT - update");
		if ( service.update(umsMemberLevelDTO) ) {
			return ResponseEntity.ok().build(); // 200 OK, found and updated
		}
		else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not updated"
		}
	}

	/**
 	 * Partial update for the given PK (if it exists )
	 *
	 * @param id
	 * @param umsMemberLevelDTO
	 * @return 200 updated or 404 not found
	 */
	@PatchMapping("/{id}")
	protected ResponseEntity<Void> partialUpdate(@PathVariable Long id, @RequestBody UmsMemberLevelDTO umsMemberLevelDTO) {
    	logger.debug("REST : PATCH - partialUpdate");
    	if ( service.partialUpdate(id, umsMemberLevelDTO) ) {
    		return ResponseEntity.ok().build(); // OK, found and updated
    	}
    	else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not updated"
    	}
	}

	/**
	 * Delete by PK 
	 *
	 * @param id
	 * @return 204 deleted or 404 not found
	 */
	@DeleteMapping("/{id}")
	protected ResponseEntity<Void> deleteById(@PathVariable Long id) {
    	logger.debug("REST : DELETE - deleteById");
		if ( service.deleteById(id) ) {
			return ResponseEntity.noContent().build(); // 204 No content = "deleted"
		}
		else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not deleted"
		}
	}

}
