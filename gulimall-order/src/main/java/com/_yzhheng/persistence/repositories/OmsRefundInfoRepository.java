/*
 * Created on 2024-05-02 ( 22:23:26 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._yzhheng.persistence.entities.OmsRefundInfo;

/**
 * Spring Data JPA repository for entity "OmsRefundInfo" <br> 
 * 
 * This repository extends PagingAndSortingRepository interface <br>
 * so it provides by default all the basic CRUD operations : <br>
 *   findById, findAll, save, delete, etc <br> 
 * with pagination and sorting : <br>
 *   findAll(Pageable), findAll(Sort)<br>
 * 
 * This repository can be extended by adding specific "finders" methods<br>
 * To do so, see the "predicates conventions" for "derived query methods" in Spring Data documentation
 * 
 * @author Telosys
 *
 */
public interface OmsRefundInfoRepository extends JpaRepository<OmsRefundInfo, Long> {

	// Insert specific finders here 

	//List<OmsRefundInfo> findByXxx(String xxx);

	//List<OmsRefundInfo> findByXxxStartingWith(String xxx);

	//List<OmsRefundInfo> findByXxxContaining(String xxx);

	//List<OmsRefundInfo> findByYyy(BigDecimal yyy);

	//List<OmsRefundInfo> findByXxxContainingAndYyy(String xxx, BigDecimal yyy);
}
