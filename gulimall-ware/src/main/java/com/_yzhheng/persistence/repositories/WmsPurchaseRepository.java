/*
 * Created on 2024-05-02 ( 19:42:32 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._yzhheng.persistence.entities.WmsPurchase;

/**
 * Spring Data JPA repository for entity "WmsPurchase" <br> 
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
public interface WmsPurchaseRepository extends JpaRepository<WmsPurchase, Long> {

	// Insert specific finders here 

	//List<WmsPurchase> findByXxx(String xxx);

	//List<WmsPurchase> findByXxxStartingWith(String xxx);

	//List<WmsPurchase> findByXxxContaining(String xxx);

	//List<WmsPurchase> findByYyy(BigDecimal yyy);

	//List<WmsPurchase> findByXxxContainingAndYyy(String xxx, BigDecimal yyy);
}
