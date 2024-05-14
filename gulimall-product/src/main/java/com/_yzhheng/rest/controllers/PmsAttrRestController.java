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

import com._yzhheng.rest.dto.PmsAttrDTO;
import com._yzhheng.rest.services.PmsAttrService;

@RestController
@RequestMapping(value = "api/v1/PmsAttr", produces = MediaType.APPLICATION_JSON_VALUE)
public class PmsAttrRestController {

	private static final Logger logger = LoggerFactory.getLogger(PmsAttrRestController.class);
	
	private PmsAttrService service ; // injected
	
	/**
	 * Constructor (usable for Dependency Injection)
	 *
	 * @param service
	 */
	protected PmsAttrRestController(PmsAttrService service) {
		super();
		this.service = service;
	}
    
	/**
	 * Get ALL
	 *
	 * @return
	 */
	@GetMapping("")
	protected ResponseEntity<List<PmsAttrDTO>> findAll() {
    	logger.debug("REST : GET - findAll");
    	List<PmsAttrDTO> list = service.findAll();
    	return ResponseEntity.ok(list); // always 200
    }
    
    /**
     * Get ONE identified by the given PK
	 *
	 * @param attrId
     * @return 200 or 404 
     */
    @GetMapping("/{attrId}")
    protected ResponseEntity<PmsAttrDTO> findById(@PathVariable Long attrId) {
    	logger.debug("REST : GET - findById");
    	PmsAttrDTO pmsAttrDTO = service.findById(attrId);
		if ( pmsAttrDTO != null ) {
			return ResponseEntity.ok(pmsAttrDTO); // 200 OK, found
		}
		else {
			return ResponseEntity.notFound().build(); // 404 Not found
		}		
    }

    
	/**
 	 * Create if doesn't exist 
	 *
	 * @param pmsAttrDTO
	 * @return 201 created or 409 conflict
	 */
	@PostMapping("")
	protected ResponseEntity<Void> create(@RequestBody PmsAttrDTO pmsAttrDTO) {
    	logger.debug("REST : POST - create");
		if ( service.create(pmsAttrDTO) ) {
			return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 created
		}
		else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict
		}
	}

	/**
	 * Update or create
	 *
	 * @param attrId
	 * @param pmsAttrDTO
	 * @return 200 updated or created
	 */
	@PutMapping("/{attrId}")
	protected ResponseEntity<Void> save(@PathVariable Long attrId, @RequestBody PmsAttrDTO pmsAttrDTO) {
    	logger.debug("REST : PUT - save");
		service.save(attrId, pmsAttrDTO);
		return ResponseEntity.ok().build(); // OK, updated or created
	}

	/**
 	 * Update if exists 
	 *
	 * @param pmsAttrDTO
	 * @return 200 updated or 404 not found
	 */
	@PutMapping("")
	protected ResponseEntity<Void> update(@RequestBody PmsAttrDTO pmsAttrDTO) {
    	logger.debug("REST : PUT - update");
		if ( service.update(pmsAttrDTO) ) {
			return ResponseEntity.ok().build(); // 200 OK, found and updated
		}
		else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not updated"
		}
	}

	/**
 	 * Partial update for the given PK (if it exists )
	 *
	 * @param attrId
	 * @param pmsAttrDTO
	 * @return 200 updated or 404 not found
	 */
	@PatchMapping("/{attrId}")
	protected ResponseEntity<Void> partialUpdate(@PathVariable Long attrId, @RequestBody PmsAttrDTO pmsAttrDTO) {
    	logger.debug("REST : PATCH - partialUpdate");
    	if ( service.partialUpdate(attrId, pmsAttrDTO) ) {
    		return ResponseEntity.ok().build(); // OK, found and updated
    	}
    	else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not updated"
    	}
	}

	/**
	 * Delete by PK 
	 *
	 * @param attrId
	 * @return 204 deleted or 404 not found
	 */
	@DeleteMapping("/{attrId}")
	protected ResponseEntity<Void> deleteById(@PathVariable Long attrId) {
    	logger.debug("REST : DELETE - deleteById");
		if ( service.deleteById(attrId) ) {
			return ResponseEntity.noContent().build(); // 204 No content = "deleted"
		}
		else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not deleted"
		}
	}

}