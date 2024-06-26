/*
 * Created on 2024-05-02 ( 16:45:39 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.services;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com._yzhheng.persistence.entities.UmsMemberCollectSpu;
import com._yzhheng.persistence.repositories.UmsMemberCollectSpuRepository;
import com._yzhheng.rest.dto.UmsMemberCollectSpuDTO;
import com._yzhheng.rest.services.commons.GenericService;

/**
 * REST service for entity "UmsMemberCollectSpu" <br>
 * 
 * This service provides all the necessary operations required by the REST controller <br>
 * 
 * @author Telosys
 *
 */
@Service
public class UmsMemberCollectSpuService extends GenericService<UmsMemberCollectSpu, UmsMemberCollectSpuDTO> {

	private static final Logger logger = LoggerFactory.getLogger(UmsMemberCollectSpuService.class);

	private final UmsMemberCollectSpuRepository repository; // injected by constructor

	/**
	 * Constructor (usable for Dependency Injection)
	 * 
	 * @param repository the repository to be injected
	 */
	public UmsMemberCollectSpuService(UmsMemberCollectSpuRepository repository) {
		super(UmsMemberCollectSpu.class, UmsMemberCollectSpuDTO.class);
		this.repository = repository;
	}
	
	/**
	 * Returns the entity ID object from the given DTO
	 *
	 * @param dto
	 * @return
	 */
	private Long getEntityId(UmsMemberCollectSpuDTO dto) {
		return dto.getId();
	}

	/**
	 * Finds all occurrences of the entity
	 *
	 * @return
	 */
	public List<UmsMemberCollectSpuDTO> findAll() {
		logger.debug("findAll()");
		Iterable<UmsMemberCollectSpu> all = repository.findAll();
		return entityListToDtoList(all);
	}

	/**
	 * Finds the entity identified by the given PK
	 *
	 * @param id 
	 * @return the entity or null if not found
	 */
	public UmsMemberCollectSpuDTO findById(Long id) {
		Long entityId = id;
		logger.debug("findById({})", entityId);
		Optional<UmsMemberCollectSpu> optionalEntity = repository.findById(entityId);
		return entityToDto(optionalEntity);
	}

	/**
	 * Saves the given entity with the given PK <br>
	 * "UPSERT" operation (updated if it exists or created if it does not exist)
	 *
	 * @param id 
	 * @param dto 
	 */
	public void save(Long id, UmsMemberCollectSpuDTO dto) {
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
	public boolean update(UmsMemberCollectSpuDTO dto) {
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
	public boolean partialUpdate(Long id, UmsMemberCollectSpuDTO dto) {
		Long entityId = id;
		logger.debug("partialUpdate({}, {})", entityId, dto);
		Optional<UmsMemberCollectSpu> optionalEntity = repository.findById(entityId);
		if (optionalEntity.isPresent()) {
			UmsMemberCollectSpu entity = optionalEntity.get();
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
	public boolean create(UmsMemberCollectSpuDTO dto) {
		logger.debug("create({})", dto);
		if (repository.existsById(getEntityId(dto))) {
			return false; // already exists, not created
		} else {
			repository.save(dtoToEntity(dto));
			return true; // created
		}
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
	public List<UmsMemberCollectSpuDTO> findByTitle(String title) {
		logger.debug("findByTitle({})", title);
		// List<UmsMemberCollectSpu> list = repository.findByTitle(title);
		List<UmsMemberCollectSpu> list = repository.findByTitleContaining(title);
		return entityListToDtoList(list);
	}

	public List<UmsMemberCollectSpuDTO> findByPrice(BigDecimal price) {
		logger.debug("findByPrice({})", price);
		// List<UmsMemberCollectSpu> list = repository.findByTitle(title);
		List<UmsMemberCollectSpu> list = repository.findByPrice(price);
		return entityListToDtoList(list);
	}

	public List<UmsMemberCollectSpuDTO> findByTitleAndPrice(String title, BigDecimal price) {
		logger.debug("findByTitleAndPrice({}, {})", title, price);
		List<UmsMemberCollectSpu> list = repository.findByTitleContainingAndPrice(title, price);
		return entityListToDtoList(list);
	}
***/
}
