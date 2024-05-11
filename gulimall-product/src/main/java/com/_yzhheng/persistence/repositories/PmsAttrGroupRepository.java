/*
 * Created on 2024-05-02 ( 14:45:35 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._yzhheng.persistence.entities.PmsAttrGroup;

/**
 * Spring Data JPA repository for entity "PmsAttrGroup" <br> 
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
public interface PmsAttrGroupRepository extends JpaRepository<PmsAttrGroup, Long> {

	// Insert specific finders here 

	//List<PmsAttrGroup> findByXxx(String xxx);

	//List<PmsAttrGroup> findByXxxStartingWith(String xxx);

	//List<PmsAttrGroup> findByXxxContaining(String xxx);

	//List<PmsAttrGroup> findByYyy(BigDecimal yyy);

	//List<PmsAttrGroup> findByXxxContainingAndYyy(String xxx, BigDecimal yyy);
}
