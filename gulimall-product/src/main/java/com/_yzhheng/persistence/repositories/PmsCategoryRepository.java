/*
 * Created on 2024-05-02 ( 14:45:35 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com._yzhheng.persistence.entities.PmsCategory;

/**
 * Spring Data JPA repository for entity "PmsCategory" <br>
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
public interface PmsCategoryRepository extends JpaRepository<PmsCategory, Long> {

	@Query(value = "Select * From pms_category where parent_cid=0", nativeQuery = true)
	List<PmsCategory> getLevel1Category();

	@Query(value = "Select * From pms_category", nativeQuery = true)
	List<PmsCategory> getAllCategories();

	// Insert specific finders here

	// List<PmsCategory> findByXxx(String xxx);

	// List<PmsCategory> findByXxxStartingWith(String xxx);

	// List<PmsCategory> findByXxxContaining(String xxx);

	// List<PmsCategory> findByYyy(BigDecimal yyy);

	// List<PmsCategory> findByXxxContainingAndYyy(String xxx, BigDecimal yyy);
}
