/*
 * Created on 2024-05-02 ( 14:45:36 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.services;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com._yzhheng.persistence.entities.PmsSkuImages;
import com._yzhheng.persistence.repositories.PmsSkuImagesRepository;
import com._yzhheng.rest.dto.PmsSkuImagesDTO;
import com._yzhheng.rest.services.commons.GenericService;

/**
 * REST service for entity "PmsSkuImages" <br>
 * 
 * This service provides all the necessary operations required by the REST controller <br>
 * 
 * @author Telosys
 *
 */
@Service
public class PmsSkuImagesService extends GenericService<PmsSkuImages, PmsSkuImagesDTO> {

	private static final Logger logger = LoggerFactory.getLogger(PmsSkuImagesService.class);

	private final PmsSkuImagesRepository repository; // injected by constructor

	/**
	 * Constructor (usable for Dependency Injection)
	 * 
	 * @param repository the repository to be injected
	 */
	public PmsSkuImagesService(PmsSkuImagesRepository repository) {
		super(PmsSkuImages.class, PmsSkuImagesDTO.class);
		this.repository = repository;
	}
	
	/**
	 * Returns the entity ID object from the given DTO
	 *
	 * @param dto
	 * @return
	 */
	private Long getEntityId(PmsSkuImagesDTO dto) {
		return dto.getId();
	}

	/**
	 * Finds all occurrences of the entity
	 *
	 * @return
	 */
	public List<PmsSkuImagesDTO> findAll() {
		logger.debug("findAll()");
		Iterable<PmsSkuImages> all = repository.findAll();
		return entityListToDtoList(all);
	}

	/**
	 * Finds the entity identified by the given PK
	 *
	 * @param id 
	 * @return the entity or null if not found
	 */
	public PmsSkuImagesDTO findById(Long id) {
		Long entityId = id;
		logger.debug("findById({})", entityId);
		Optional<PmsSkuImages> optionalEntity = repository.findById(entityId);
		return entityToDto(optionalEntity);
	}

	/**
	 * Saves the given entity with the given PK <br>
	 * "UPSERT" operation (updated if it exists or created if it does not exist)
	 *
	 * @param id 
	 * @param dto 
	 */
	public void save(Long id, PmsSkuImagesDTO dto) {
		Long entityId = id;
		logger.debug("save({},{})", entityId, dto);
		// force PK in DTO (just to be sure to conform with the given PK) 
		dto.setId(id);
		repository.save(dtoToEntity(dto));
	}

	/**
	 * Updates the given entity if it exists
	 *
	 * @param dto
	 * @return true if updated, false if not found
	 */
	public boolean update(PmsSkuImagesDTO dto) {
		logger.debug("update({})", dto);
		if (repository.existsById(getEntityId(dto))) {
			repository.save(dtoToEntity(dto));
			return true; // find and updated
		} else {
			return false; // not found (not updated)
		}
	}

	/**
	 * Updates partially the given entity if it exists
	 *
	 * @param id 
	 * @param dto
	 * @return true if updated, false if not found
	 */
	public boolean partialUpdate(Long id, PmsSkuImagesDTO dto) {
		Long entityId = id;
		logger.debug("partialUpdate({}, {})", entityId, dto);
		Optional<PmsSkuImages> optionalEntity = repository.findById(entityId);
		if (optionalEntity.isPresent()) {
			PmsSkuImages entity = optionalEntity.get();
			// implement here the partial update
			// entity.setXxx(dto.getXxx());
			// etc ...
			repository.save(entity);
			return true; // find and updated
		} else {
			return false; // not found (not updated)
		}
	}

	/**
	 * Creates the given entity
	 *
	 * @param dto
	 * @return true if created, false if already exists
	 */
	public boolean create(PmsSkuImagesDTO dto) {
		logger.debug("create({})", dto);
		// auto-generated Primary Key
		repository.save(dtoToEntity(dto));
		return true; // always created
	}

	/**
	 * Deletes an entity by its PK
	 *
	 * @param id 
	 * @return true if deleted, false if not found
	 */
	public boolean deleteById(Long id) {
		Long entityId = id;
		logger.debug("deleteById({})", entityId);
		if (repository.existsById(entityId)) {
			repository.deleteById(entityId);
			return true; // find and deleted
		} else {
			return false; // not found (not deleted)
		}
	}

	// -----------------------------------------------------------------------------------------
	// Specific "finders"
	// -----------------------------------------------------------------------------------------
/***
	public List<PmsSkuImagesDTO> findByTitle(String title) {
		logger.debug("findByTitle({})", title);
		// List<PmsSkuImages> list = repository.findByTitle(title);
		List<PmsSkuImages> list = repository.findByTitleContaining(title);
		return entityListToDtoList(list);
	}

	public List<PmsSkuImagesDTO> findByPrice(BigDecimal price) {
		logger.debug("findByPrice({})", price);
		// List<PmsSkuImages> list = repository.findByTitle(title);
		List<PmsSkuImages> list = repository.findByPrice(price);
		return entityListToDtoList(list);
	}

	public List<PmsSkuImagesDTO> findByTitleAndPrice(String title, BigDecimal price) {
		logger.debug("findByTitleAndPrice({}, {})", title, price);
		List<PmsSkuImages> list = repository.findByTitleContainingAndPrice(title, price);
		return entityListToDtoList(list);
	}
***/
}
