package com._yzhheng.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.RestHighLevelClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticConfiguration {

    public static final RequestOptions COMMON_OPTIONS;
    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        // builder.addHeader("Authorization", "Bearer " + TOKEN);
        // builder.setHttpAsyncResponseConsumerFactory(
        // new HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory(30 *
        // 1024 * 1024 * 1024));
        COMMON_OPTIONS = builder.build();
    }

    @Bean
    public RestHighLevelClient esClient() {
        RestClient httpClient = RestClient.builder(
                new HttpHost("localhost", 9200)).build();

        // Create the HLRC
        RestHighLevelClient hlrc = new RestHighLevelClientBuilder(httpClient)
                .setApiCompatibilityMode(true)
                .build();
        return hlrc;
    }
}
