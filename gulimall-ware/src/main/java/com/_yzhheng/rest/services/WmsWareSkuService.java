/*
 * Created on 2024-05-02 ( 19:42:32 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com._yzhheng.dto.HasStockDto;
import com._yzhheng.persistence.entities.WmsWareSku;
import com._yzhheng.persistence.repositories.WmsWareSkuRepository;
import com._yzhheng.rest.dto.WmsWareSkuDTO;
import com._yzhheng.rest.services.commons.GenericService;

/**
 * REST service for entity "WmsWareSku" <br>
 * 
 * This service provides all the necessary operations required by the REST
 * controller <br>
 * 
 * @author Telosys
 *
 */
@Service
public class WmsWareSkuService extends GenericService<WmsWareSku, WmsWareSkuDTO> {

	private static final Logger logger = LoggerFactory.getLogger(WmsWareSkuService.class);

	private final WmsWareSkuRepository repository; // injected by constructor

	/**
	 * Constructor (usable for Dependency Injection)
	 * 
	 * @param repository the repository to be injected
	 */
	public WmsWareSkuService(WmsWareSkuRepository repository) {
		super(WmsWareSku.class, WmsWareSkuDTO.class);
		this.repository = repository;
	}

	/**
	 * Returns the entity ID object from the given DTO
	 *
	 * @param dto
	 * @return
	 */
	private Long getEntityId(WmsWareSkuDTO dto) {
		return dto.getId();
	}

	/**
	 * Finds all occurrences of the entity
	 *
	 * @return
	 */
	public List<WmsWareSkuDTO> findAll() {
		logger.debug("findAll()");
		Iterable<WmsWareSku> all = repository.findAll();
		return entityListToDtoList(all);
	}

	/**
	 * Finds the entity identified by the given PK
	 *
	 * @param id
	 * @return the entity or null if not found
	 */
	public WmsWareSkuDTO findById(Long id) {
		Long entityId = id;
		logger.debug("findById({})", entityId);
		Optional<WmsWareSku> optionalEntity = repository.findById(entityId);
		return entityToDto(optionalEntity);
	}

	/**
	 * Saves the given entity with the given PK <br>
	 * "UPSERT" operation (updated if it exists or created if it does not exist)
	 *
	 * @param id
	 * @param dto
	 */
	public void save(Long id, WmsWareSkuDTO dto) {
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
	public boolean update(WmsWareSkuDTO dto) {
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
	public boolean partialUpdate(Long id, WmsWareSkuDTO dto) {
		Long entityId = id;
		logger.debug("partialUpdate({}, {})", entityId, dto);
		Optional<WmsWareSku> optionalEntity = repository.findById(entityId);
		if (optionalEntity.isPresent()) {
			WmsWareSku entity = optionalEntity.get();
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
	public boolean create(WmsWareSkuDTO dto) {
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

	public List<HasStockDto> getSkuHasStock(List<Long> skuIds) {
		// TODO Auto-generated method stub
		List<HasStockDto> dtos = skuIds.stream().map(id -> {
			HasStockDto dto = new HasStockDto();
			Long count = repository.checkStock(id);
			dto.setSkuId(id);
			dto.setHasStock(count == null ? false : count > 0);
			return dto;
		}).collect(Collectors.toList());
		return dtos;
	}

	// -----------------------------------------------------------------------------------------
	// Specific "finders"
	// -----------------------------------------------------------------------------------------
	/***
	 * public List<WmsWareSkuDTO> findByTitle(String title) {
	 * logger.debug("findByTitle({})", title);
	 * // List<WmsWareSku> list = repository.findByTitle(title);
	 * List<WmsWareSku> list = repository.findByTitleContaining(title);
	 * return entityListToDtoList(list);
	 * }
	 * 
	 * public List<WmsWareSkuDTO> findByPrice(BigDecimal price) {
	 * logger.debug("findByPrice({})", price);
	 * // List<WmsWareSku> list = repository.findByTitle(title);
	 * List<WmsWareSku> list = repository.findByPrice(price);
	 * return entityListToDtoList(list);
	 * }
	 * 
	 * public List<WmsWareSkuDTO> findByTitleAndPrice(String title, BigDecimal
	 * price) {
	 * logger.debug("findByTitleAndPrice({}, {})", title, price);
	 * List<WmsWareSku> list = repository.findByTitleContainingAndPrice(title,
	 * price);
	 * return entityListToDtoList(list);
	 * }
	 ***/
}
