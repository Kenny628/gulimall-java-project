package com._yzhheng.gulimallproduct;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com._yzhheng.persistence.repositories.PmsAttrGroupRepository;
import com._yzhheng.persistence.repositories.PmsAttrRepository;
import com._yzhheng.rest.dto.databaseSpuDto;

@SpringBootTest
class GulimallProductApplicationTests {

	@Autowired
	PmsAttrGroupRepository pmsAttrGroupRepository;

	@Test
	void test() {

		// List<databaseSpuDto> spu =
		// pmsAttrGroupRepository.getAttrGroupWithAttrsBySpuId(3L, 225L);
		// for (databaseSpuDto sp : spu) {
		// System.out.println(sp.getAttrGroupName() + " : " + sp.getAttrName() + " : " +
		// sp.getAttrValue());
		// }
	}

}
