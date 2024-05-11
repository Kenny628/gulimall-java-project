/*
 * Created on 2024-05-02 ( 16:20:01 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.services;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com._yzhheng.persistence.entities.SmsCoupon;
import com._yzhheng.persistence.repositories.SmsCouponRepository;
import com._yzhheng.rest.dto.SmsCouponDTO;
import com._yzhheng.rest.services.commons.GenericService;

/**
 * REST service for entity "SmsCoupon" <br>
 * 
 * This service provides all the necessary operations required by the REST controller <br>
 * 
 * @author Telosys
 *
 */
@Service
public class SmsCouponService extends GenericService<SmsCoupon, SmsCouponDTO> {

	private static final Logger logger = LoggerFactory.getLogger(SmsCouponService.class);

	private final SmsCouponRepository repository; // injected by constructor

	/**
	 * Constructor (usable for Dependency Injection)
	 * 
	 * @param repository the repository to be injected
	 */
	public SmsCouponService(SmsCouponRepository repository) {
		super(SmsCoupon.class, SmsCouponDTO.class);
		this.repository = repository;
	}
	
	/**
	 * Returns the entity ID object from the given DTO
	 *
	 * @param dto
	 * @return
	 */
	private Long getEntityId(SmsCouponDTO dto) {
		return dto.getId();
	}

	/**
	 * Finds all occurrences of the entity
	 *
	 * @return
	 */
	public List<SmsCouponDTO> findAll() {
		logger.debug("findAll()");
		Iterable<SmsCoupon> all = repository.findAll();
		return entityListToDtoList(all);
	}

	/**
	 * Finds the entity identified by the given PK
	 *
	 * @param id 
	 * @return the entity or null if not found
	 */
	public SmsCouponDTO findById(Long id) {
		Long entityId = id;
		logger.debug("findById({})", entityId);
		Optional<SmsCoupon> optionalEntity = repository.findById(entityId);
		return entityToDto(optionalEntity);
	}

	/**
	 * Saves the given entity with the given PK <br>
	 * "UPSERT" operation (updated if it exists or created if it does not exist)
	 *
	 * @param id 
	 * @param dto 
	 */
	public void save(Long id, SmsCouponDTO dto) {
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
	public boolean update(SmsCouponDTO dto) {
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
	public boolean partialUpdate(Long id, SmsCouponDTO dto) {
		Long entityId = id;
		logger.debug("partialUpdate({}, {})", entityId, dto);
		Optional<SmsCoupon> optionalEntity = repository.findById(entityId);
		if (optionalEntity.isPresent()) {
			SmsCoupon entity = optionalEntity.get();
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
	public boolean create(SmsCouponDTO dto) {
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
	public List<SmsCouponDTO> findByTitle(String title) {
		logger.debug("findByTitle({})", title);
		// List<SmsCoupon> list = repository.findByTitle(title);
		List<SmsCoupon> list = repository.findByTitleContaining(title);
		return entityListToDtoList(list);
	}

	public List<SmsCouponDTO> findByPrice(BigDecimal price) {
		logger.debug("findByPrice({})", price);
		// List<SmsCoupon> list = repository.findByTitle(title);
		List<SmsCoupon> list = repository.findByPrice(price);
		return entityListToDtoList(list);
	}

	public List<SmsCouponDTO> findByTitleAndPrice(String title, BigDecimal price) {
		logger.debug("findByTitleAndPrice({}, {})", title, price);
		List<SmsCoupon> list = repository.findByTitleContainingAndPrice(title, price);
		return entityListToDtoList(list);
	}
***/
}
