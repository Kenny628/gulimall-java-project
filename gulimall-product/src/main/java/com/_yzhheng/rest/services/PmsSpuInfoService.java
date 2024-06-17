/*
 * Created on 2024-05-02 ( 14:45:36 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com._yzhheng.dto.HasStockDto;
import com._yzhheng.dto.SkuEsModel;
import com._yzhheng.persistence.entities.PmsBrand;
import com._yzhheng.persistence.entities.PmsProductAttrValue;
import com._yzhheng.persistence.entities.PmsSkuInfo;
import com._yzhheng.persistence.entities.PmsSpuInfo;
import com._yzhheng.persistence.repositories.PmsAttrRepository;
import com._yzhheng.persistence.repositories.PmsProductAttrValueRepository;
import com._yzhheng.persistence.repositories.PmsSkuInfoRepository;
import com._yzhheng.persistence.repositories.PmsSpuInfoRepository;
import com._yzhheng.rest.Feign.SearchFeign;
import com._yzhheng.rest.Feign.WareFeign;
import com._yzhheng.rest.dto.PmsBrandDTO;
import com._yzhheng.rest.dto.PmsCategoryDTO;
import com._yzhheng.rest.dto.PmsSpuInfoDTO;
import com._yzhheng.rest.services.commons.GenericService;

/**
 * REST service for entity "PmsSpuInfo" <br>
 * 
 * This service provides all the necessary operations required by the REST
 * controller <br>
 * 
 * @author Telosys
 *
 */
@Service
public class PmsSpuInfoService extends GenericService<PmsSpuInfo, PmsSpuInfoDTO> {

	private static final Logger logger = LoggerFactory.getLogger(PmsSpuInfoService.class);

	private final PmsSpuInfoRepository repository; // injected by constructor
	private final PmsSkuInfoRepository skuRepository;

	private final PmsProductAttrValueRepository productAttrValueRepository;
	private final PmsAttrRepository productAttrRepository;
	@Autowired
	WareFeign produtFeign;
	@Autowired
	SearchFeign searchFeign;
	private final PmsBrandService brandService;
	private final PmsCategoryService categoryService;

	/**
	 * Constructor (usable for Dependency Injection)
	 * 
	 * @param repository the repository to be injected
	 */
	public PmsSpuInfoService(PmsSpuInfoRepository repository, PmsSkuInfoRepository skuRepository,
			PmsProductAttrValueRepository productAttrValueRepository, PmsAttrRepository productAttrRepository,
			PmsBrandService brandService, PmsCategoryService categoryService) {
		super(PmsSpuInfo.class, PmsSpuInfoDTO.class);
		this.repository = repository;
		this.skuRepository = skuRepository;
		this.productAttrValueRepository = productAttrValueRepository;
		this.productAttrRepository = productAttrRepository;
		this.brandService = brandService;
		this.categoryService = categoryService;
	}

	/**
	 * Returns the entity ID object from the given DTO
	 *
	 * @param dto
	 * @return
	 */
	private Long getEntityId(PmsSpuInfoDTO dto) {
		return dto.getId();
	}

	/**
	 * Finds all occurrences of the entity
	 *
	 * @return
	 */
	public List<PmsSpuInfoDTO> findAll() {
		logger.debug("findAll()");
		Iterable<PmsSpuInfo> all = repository.findAll();
		return entityListToDtoList(all);
	}

	/**
	 * Finds the entity identified by the given PK
	 *
	 * @param id
	 * @return the entity or null if not found
	 */
	public PmsSpuInfoDTO findById(Long id) {
		Long entityId = id;
		logger.debug("findById({})", entityId);
		Optional<PmsSpuInfo> optionalEntity = repository.findById(entityId);
		return entityToDto(optionalEntity);
	}

	/**
	 * Saves the given entity with the given PK <br>
	 * "UPSERT" operation (updated if it exists or created if it does not exist)
	 *
	 * @param id
	 * @param dto
	 */
	public void save(Long id, PmsSpuInfoDTO dto) {
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
	public boolean update(PmsSpuInfoDTO dto) {
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
	public boolean partialUpdate(Long id, PmsSpuInfoDTO dto) {
		Long entityId = id;
		logger.debug("partialUpdate({}, {})", entityId, dto);
		Optional<PmsSpuInfo> optionalEntity = repository.findById(entityId);
		if (optionalEntity.isPresent()) {
			PmsSpuInfo entity = optionalEntity.get();
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
	public boolean create(PmsSpuInfoDTO dto) {
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

	public void upSpu(Long spuId) {
		// 查询当前spuid对应的所有sku信息，品牌的名字
		List<PmsSkuInfo> skuInfoList = skuRepository.getAllSkuBySpuId(spuId).get();
		List<Long> skuIdList = skuInfoList.stream().map(id -> id.getSkuId()).collect(Collectors.toList());
		// 查询当前sku所有 可以被用来检索 的规格属性
		List<PmsProductAttrValue> pmsProductAttrValues = productAttrValueRepository.getAttributesBySpu(spuId).get();
		List<Long> attrIds = pmsProductAttrValues.stream().map(attr -> {
			return attr.getAttrId();
		}).collect(Collectors.toList());
		// attrIds = new List<Long>(1, 3);
		// List<Long> test = new ArrayList<>(List.of(1L, 2L, 3));
		String attrIdsInCommaFormat = attrIds.stream()
				.map(id -> id.toString())
				.collect(Collectors.joining(","));
		List<Long> searchAttrids = productAttrRepository.getSearchableAttrByAttrIds(attrIdsInCommaFormat);
		List<SkuEsModel.Attrs> attrsList = pmsProductAttrValues.stream()
				.filter(productAttrValueEntity -> searchAttrids.contains(productAttrValueEntity.getAttrId())

				).map(item -> {
					SkuEsModel.Attrs attrs1 = new SkuEsModel.Attrs();
					BeanUtils.copyProperties(item, attrs1);
					return attrs1;
				}).collect(Collectors.toList());
		Map<Long, Boolean> stockMap = null;
		try {

			// 遠程調用
			List<HasStockDto> dtos = produtFeign.getSkuHasStock(skuIdList).getBody();

			stockMap = dtos.stream()
					.collect(Collectors.toMap(dto -> dto.getSkuId(), dto -> dto.getHasStock()));
		} catch (Exception e) {
			// log.error("库存服务查询异常：原因{}", e);
			System.out.println("库存服务查询异常：原因{}" + e);
		}

		Map<Long, Boolean> finalStockMap = stockMap;
		List<SkuEsModel> upProducts = skuInfoList.stream().map(sku -> {
			// 组装需要的数据
			SkuEsModel skuEsModel = new SkuEsModel();
			BeanUtils.copyProperties(sku, skuEsModel);

			skuEsModel.setSkuPrice(sku.getPrice());
			skuEsModel.setSkuImg(sku.getSkuDefaultImg());

			// 设置库存信息
			if (finalStockMap == null) {
				skuEsModel.setHasStock(true);
			} else {
				skuEsModel.setHasStock(finalStockMap.get(sku.getSkuId()));
			}

			// 2、热度评价，0
			skuEsModel.setHotScore(0L);

			// 3、查询品牌的名字和图片信息
			PmsBrandDTO brand = brandService.findById(skuEsModel.getBrandId());
			skuEsModel.setBrandName(brand.getName());
			skuEsModel.setBrandImg(brand.getLogo());

			// 4、查询分类的名字和图片信息
			PmsCategoryDTO category = categoryService.findById(skuEsModel.getCatalogId());
			skuEsModel.setCatalogName(category.getName());

			// 设置检索属性
			skuEsModel.setAttrs(attrsList);

			return skuEsModel;
		}).collect(Collectors.toList());

		ResponseEntity<Void> r = searchFeign.productStatusUp(upProducts);
		if (r.getStatusCode() == HttpStatus.OK) {
			// 远程调用成功
			// 7、修改当前spu的状态
			int publishStatus = 1;
			repository.updateSpuStatus(spuId, publishStatus);
		}
	}

	// -----------------------------------------------------------------------------------------
	// Specific "finders"
	// -----------------------------------------------------------------------------------------
	/***
	 * public List<PmsSpuInfoDTO> findByTitle(String title) {
	 * logger.debug("findByTitle({})", title);
	 * // List<PmsSpuInfo> list = repository.findByTitle(title);
	 * List<PmsSpuInfo> list = repository.findByTitleContaining(title);
	 * return entityListToDtoList(list);
	 * }
	 * 
	 * public List<PmsSpuInfoDTO> findByPrice(BigDecimal price) {
	 * logger.debug("findByPrice({})", price);
	 * // List<PmsSpuInfo> list = repository.findByTitle(title);
	 * List<PmsSpuInfo> list = repository.findByPrice(price);
	 * return entityListToDtoList(list);
	 * }
	 * 
	 * public List<PmsSpuInfoDTO> findByTitleAndPrice(String title, BigDecimal
	 * price) {
	 * logger.debug("findByTitleAndPrice({}, {})", title, price);
	 * List<PmsSpuInfo> list = repository.findByTitleContainingAndPrice(title,
	 * price);
	 * return entityListToDtoList(list);
	 * }
	 ***/

}
