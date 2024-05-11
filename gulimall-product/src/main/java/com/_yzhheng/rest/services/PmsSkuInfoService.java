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

import com._yzhheng.persistence.entities.PmsSkuInfo;
import com._yzhheng.persistence.repositories.PmsSkuInfoRepository;
import com._yzhheng.rest.dto.PmsSkuInfoDTO;
import com._yzhheng.rest.services.commons.GenericService;

/**
 * REST service for entity "PmsSkuInfo" <br>
 * 
 * This service provides all the necessary operations required by the REST controller <br>
 * 
 * @author Telosys
 *
 */
@Service
public class PmsSkuInfoService extends GenericService<PmsSkuInfo, PmsSkuInfoDTO> {

	private static final Logger logger = LoggerFactory.getLogger(PmsSkuInfoService.class);

	private final PmsSkuInfoRepository repository; // injected by constructor

	/**
	 * Constructor (usable for Dependency Injection)
	 * 
	 * @param repository the repository to be injected
	 */
	public PmsSkuInfoService(PmsSkuInfoRepository repository) {
		super(PmsSkuInfo.class, PmsSkuInfoDTO.class);
		this.repository = repository;
	}
	
	/**
	 * Returns the entity ID object from the given DTO
	 *
	 * @param dto
	 * @return
	 */
	private Long getEntityId(PmsSkuInfoDTO dto) {
		return dto.getSkuId();
	}

	/**
	 * Finds all occurrences of the entity
	 *
	 * @return
	 */
	public List<PmsSkuInfoDTO> findAll() {
		logger.debug("findAll()");
		Iterable<PmsSkuInfo> all = repository.findAll();
		return entityListToDtoList(all);
	}

	/**
	 * Finds the entity identified by the given PK
	 *
	 * @param skuId 
	 * @return the entity or null if not found
	 */
	public PmsSkuInfoDTO findById(Long skuId) {
		Long entityId = skuId;
		logger.debug("findById({})", entityId);
		Optional<PmsSkuInfo> optionalEntity = repository.findById(entityId);
		return entityToDto(optionalEntity);
	}

	/**
	 * Saves the given entity with the given PK <br>
	 * "UPSERT" operation (updated if it exists or created if it does not exist)
	 *
	 * @param skuId 
	 * @param dto 
	 */
	public void save(Long skuId, PmsSkuInfoDTO dto) {
		Long entityId = skuId;
		logger.debug("save({},{})", entityId, dto);
		// force PK in DTO (just to be sure to conform with the given PK) 
		dto.setSkuId(skuId);
		repository.save(dtoToEntity(dto));
	}

	/**
	 * Updates the given entity if it exists
	 *
	 * @param dto
	 * @return true if updated, false if not found
	 */
	public boolean update(PmsSkuInfoDTO dto) {
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
	 * @param skuId 
	 * @param dto
	 * @return true if updated, false if not found
	 */
	public boolean partialUpdate(Long skuId, PmsSkuInfoDTO dto) {
		Long entityId = skuId;
		logger.debug("partialUpdate({}, {})", entityId, dto);
		Optional<PmsSkuInfo> optionalEntity = repository.findById(entityId);
		if (optionalEntity.isPresent()) {
			PmsSkuInfo entity = optionalEntity.get();
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
	public boolean create(PmsSkuInfoDTO dto) {
		logger.debug("create({})", dto);
		// auto-generated Primary Key
		repository.save(dtoToEntity(dto));
		return true; // always created
	}

	/**
	 * Deletes an entity by its PK
	 *
	 * @param skuId 
	 * @return true if deleted, false if not found
	 */
	public boolean deleteById(Long skuId) {
		Long entityId = skuId;
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
	public List<PmsSkuInfoDTO> findByTitle(String title) {
		logger.debug("findByTitle({})", title);
		// List<PmsSkuInfo> list = repository.findByTitle(title);
		List<PmsSkuInfo> list = repository.findByTitleContaining(title);
		return entityListToDtoList(list);
	}

	public List<PmsSkuInfoDTO> findByPrice(BigDecimal price) {
		logger.debug("findByPrice({})", price);
		// List<PmsSkuInfo> list = repository.findByTitle(title);
		List<PmsSkuInfo> list = repository.findByPrice(price);
		return entityListToDtoList(list);
	}

	public List<PmsSkuInfoDTO> findByTitleAndPrice(String title, BigDecimal price) {
		logger.debug("findByTitleAndPrice({}, {})", title, price);
		List<PmsSkuInfo> list = repository.findByTitleContainingAndPrice(title, price);
		return entityListToDtoList(list);
	}
***/
}
