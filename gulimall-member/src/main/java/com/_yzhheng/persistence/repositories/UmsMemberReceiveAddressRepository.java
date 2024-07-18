/*
 * Created on 2024-05-02 ( 16:45:39 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com._yzhheng.persistence.entities.UmsMemberReceiveAddress;

/**
 * Spring Data JPA repository for entity "UmsMemberReceiveAddress" <br>
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
public interface UmsMemberReceiveAddressRepository extends JpaRepository<UmsMemberReceiveAddress, Long> {

	@Query(value = "Select * from ums_member_receive_address where member_id = :memberId", nativeQuery = true)
	List<UmsMemberReceiveAddress> getAddress(Long memberId);

	// Insert specific finders here

	// List<UmsMemberReceiveAddress> findByXxx(String xxx);

	// List<UmsMemberReceiveAddress> findByXxxStartingWith(String xxx);

	// List<UmsMemberReceiveAddress> findByXxxContaining(String xxx);

	// List<UmsMemberReceiveAddress> findByYyy(BigDecimal yyy);

	// List<UmsMemberReceiveAddress> findByXxxContainingAndYyy(String xxx,
	// BigDecimal yyy);
}
