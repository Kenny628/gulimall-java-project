package com._yzhheng.gulimallsearch;

import java.io.IOException;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com._yzhheng.config.ElasticConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class GulimallSearchApplicationTests {

	@Autowired
	private RestHighLevelClient hlrc;

	class User {

		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	@Test
	public void testIndex() throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		IndexRequest request = new IndexRequest("users");
		request.id("1");
		User user = new User();
		user.setName("nammeee");
		String jsonn = mapper.writeValueAsString(user);// check here
		request.source(jsonn, XContentType.JSON);
		IndexResponse index = hlrc.index(request, ElasticConfiguration.COMMON_OPTIONS);
		System.out.println(index);
	}

	@Test
	void contextLoads() {
		System.out.println(hlrc);
	}

}
