/*
 * Created on 2024-05-02 ( 16:20:02 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._yzhheng.persistence.entities.SmsMemberPrice;

/**
 * Spring Data JPA repository for entity "SmsMemberPrice" <br> 
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
public interface SmsMemberPriceRepository extends JpaRepository<SmsMemberPrice, Long> {

	// Insert specific finders here 

	//List<SmsMemberPrice> findByXxx(String xxx);

	//List<SmsMemberPrice> findByXxxStartingWith(String xxx);

	//List<SmsMemberPrice> findByXxxContaining(String xxx);

	//List<SmsMemberPrice> findByYyy(BigDecimal yyy);

	//List<SmsMemberPrice> findByXxxContainingAndYyy(String xxx, BigDecimal yyy);
}
