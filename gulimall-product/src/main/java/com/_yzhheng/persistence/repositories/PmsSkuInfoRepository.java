/*
 * Created on 2024-05-02 ( 14:45:36 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com._yzhheng.persistence.entities.PmsSkuInfo;
import com._yzhheng.rest.databaseDto.PmsSkuItemSaleAttrVo;

/**
 * Spring Data JPA repository for entity "PmsSkuInfo" <br>
 * 
 * This repository extends PagingAndSortingRepository interface <br>
 * so it provides by default all the basic CRUD operations : <br>
 * findById, findAll, save, delete, etc <br>
 * with pagination and sorting : <br>
 * findAll(Pageable), findAll(Sort)<br>
 * 
 * This repository can be extended by adding specific "finders" methods<br>
 * To do so, see the "predicates conventions" for "derived query methods" in
 * Spring Data documentation
 * 
 * @author Telosys
 *
 */
public interface PmsSkuInfoRepository extends JpaRepository<PmsSkuInfo, Long> {

	@Query(value = "SELECT * FROM pms_sku_info where spu_id = :spuId", nativeQuery = true)
	Optional<List<PmsSkuInfo>> getAllSkuBySpuId(Long spuId);

	@Query(value = "select ssav.attr_name attr_name, ssav.attr_value, group_concat(info.sku_id) skuIds FROM pms_sku_info info LEFT JOIN pms_sku_sale_attr_value ssav ON ssav.sku_id = info.sku_id WHERE info.spu_id = :spuId GROUP BY ssav.attr_id, ssav.attr_name, ssav.attr_value", nativeQuery = true)
	List<Object[]> getSaleAttrBySpuId(Long spuId);

	@Query(value = "select * from pms_sku_info where MATCH(sku_name) AGAINST (:sku_name)", nativeQuery = true)
	Page<PmsSkuInfo> searchSkusBySku_NameInputedByUser(Pageable pageable, String sku_name);
	// Insert specific finders here

	@Query(value = "select * from pms_sku_info where MATCH(sku_name) AGAINST (:userInputedText)", nativeQuery = true)
	List<PmsSkuInfo> searchALLSkusByUserInputedText(String userInputedText);

	@Query(value = "select * from pms_sku_info where catalog_id=:catalog3Id", nativeQuery = true)
	Page<PmsSkuInfo> searchSkusBycatalog3Id(Pageable pageable, Long catalog3Id);

	@Query(value = "select * from pms_sku_info where catalog_id=:catalog3Id", nativeQuery = true)
	List<PmsSkuInfo> searchALLSkusByCatalog3Id(Long catalog3Id);

	@Query(value = "select * from pms_sku_info ORDER BY RAND()", nativeQuery = true)
	List<PmsSkuInfo> findAllWithRandom();

	// List<PmsSkuInfo> findByXxx(String xxx);

	// List<PmsSkuInfo> findByXxxStartingWith(String xxx);

	// List<PmsSkuInfo> findByXxxContaining(String xxx);

	// List<PmsSkuInfo> findByYyy(BigDecimal yyy);

	// List<PmsSkuInfo> findByXxxContainingAndYyy(String xxx, BigDecimal yyy);
}
