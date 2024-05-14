/*
 * Created on 2024-05-02 ( 15:34:00 )
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

import com._yzhheng.rest.dto.PmsSkuInfoDTO;
import com._yzhheng.rest.services.PmsSkuInfoService;

@RestController
@RequestMapping(value = "api/v1/PmsSkuInfo", produces = MediaType.APPLICATION_JSON_VALUE)
public class PmsSkuInfoRestController {

	private static final Logger logger = LoggerFactory.getLogger(PmsSkuInfoRestController.class);
	
	private PmsSkuInfoService service ; // injected
	
	/**
	 * Constructor (usable for Dependency Injection)
	 *
	 * @param service
	 */
	protected PmsSkuInfoRestController(PmsSkuInfoService service) {
		super();
		this.service = service;
	}
    
	/**
	 * Get ALL
	 *
	 * @return
	 */
	@GetMapping("")
	protected ResponseEntity<List<PmsSkuInfoDTO>> findAll() {
    	logger.debug("REST : GET - findAll");
    	List<PmsSkuInfoDTO> list = service.findAll();
    	return ResponseEntity.ok(list); // always 200
    }
    
    /**
     * Get ONE identified by the given PK
	 *
	 * @param skuId
     * @return 200 or 404 
     */
    @GetMapping("/{skuId}")
    protected ResponseEntity<PmsSkuInfoDTO> findById(@PathVariable Long skuId) {
    	logger.debug("REST : GET - findById");
    	PmsSkuInfoDTO pmsSkuInfoDTO = service.findById(skuId);
		if ( pmsSkuInfoDTO != null ) {
			return ResponseEntity.ok(pmsSkuInfoDTO); // 200 OK, found
		}
		else {
			return ResponseEntity.notFound().build(); // 404 Not found
		}		
    }

    
	/**
 	 * Create if doesn't exist 
	 *
	 * @param pmsSkuInfoDTO
	 * @return 201 created or 409 conflict
	 */
	@PostMapping("")
	protected ResponseEntity<Void> create(@RequestBody PmsSkuInfoDTO pmsSkuInfoDTO) {
    	logger.debug("REST : POST - create");
		if ( service.create(pmsSkuInfoDTO) ) {
			return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 created
		}
		else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict
		}
	}

	/**
	 * Update or create
	 *
	 * @param skuId
	 * @param pmsSkuInfoDTO
	 * @return 200 updated or created
	 */
	@PutMapping("/{skuId}")
	protected ResponseEntity<Void> save(@PathVariable Long skuId, @RequestBody PmsSkuInfoDTO pmsSkuInfoDTO) {
    	logger.debug("REST : PUT - save");
		service.save(skuId, pmsSkuInfoDTO);
		return ResponseEntity.ok().build(); // OK, updated or created
	}

	/**
 	 * Update if exists 
	 *
	 * @param pmsSkuInfoDTO
	 * @return 200 updated or 404 not found
	 */
	@PutMapping("")
	protected ResponseEntity<Void> update(@RequestBody PmsSkuInfoDTO pmsSkuInfoDTO) {
    	logger.debug("REST : PUT - update");
		if ( service.update(pmsSkuInfoDTO) ) {
			return ResponseEntity.ok().build(); // 200 OK, found and updated
		}
		else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not updated"
		}
	}

	/**
 	 * Partial update for the given PK (if it exists )
	 *
	 * @param skuId
	 * @param pmsSkuInfoDTO
	 * @return 200 updated or 404 not found
	 */
	@PatchMapping("/{skuId}")
	protected ResponseEntity<Void> partialUpdate(@PathVariable Long skuId, @RequestBody PmsSkuInfoDTO pmsSkuInfoDTO) {
    	logger.debug("REST : PATCH - partialUpdate");
    	if ( service.partialUpdate(skuId, pmsSkuInfoDTO) ) {
    		return ResponseEntity.ok().build(); // OK, found and updated
    	}
    	else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not updated"
    	}
	}

	/**
	 * Delete by PK 
	 *
	 * @param skuId
	 * @return 204 deleted or 404 not found
	 */
	@DeleteMapping("/{skuId}")
	protected ResponseEntity<Void> deleteById(@PathVariable Long skuId) {
    	logger.debug("REST : DELETE - deleteById");
		if ( service.deleteById(skuId) ) {
			return ResponseEntity.noContent().build(); // 204 No content = "deleted"
		}
		else {
			return ResponseEntity.notFound().build(); // 404 Not found = "not deleted"
		}
	}

}