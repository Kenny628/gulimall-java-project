/*
 * Created on 2024-05-02 ( 19:42:32 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com._yzhheng.persistence.entities.WmsWareSku;

/**
 * Spring Data JPA repository for entity "WmsWareSku" <br>
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
public interface WmsWareSkuRepository extends JpaRepository<WmsWareSku, Long> {

	@Query(value = "SELECT SUM(stock-stock_locked) FROM wms_ware_sku where sku_id = :skuId group by sku_id", nativeQuery = true)
	Long checkStock(long skuId);

	// Insert specific finders here

	// List<WmsWareSku> findByXxx(String xxx);

	// List<WmsWareSku> findByXxxStartingWith(String xxx);

	// List<WmsWareSku> findByXxxContaining(String xxx);

	// List<WmsWareSku> findByYyy(BigDecimal yyy);

	// List<WmsWareSku> findByXxxContainingAndYyy(String xxx, BigDecimal yyy);
}
