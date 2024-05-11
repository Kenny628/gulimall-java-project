package com._yzhheng.rest.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._yzhheng.config.ElasticConfiguration;
import com._yzhheng.constant.EsConstant;
import com._yzhheng.dto.SkuEsModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SaveToEsService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException {

        // 保存数据到es
        // 1. 给es中建立索引，建立映射关系

        // 2. 给es中保存这些数据
        BulkRequest bulkRequest = new BulkRequest();
        for (SkuEsModel model : skuEsModels) {
            ObjectMapper mapper = new ObjectMapper();
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(model.getSkuId().toString());
            String s = mapper.writeValueAsString(model);
            indexRequest.source(s, XContentType.JSON);

            bulkRequest.add(indexRequest);
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, ElasticConfiguration.COMMON_OPTIONS);

        // TODO 如果批量错误
        boolean b = bulk.hasFailures();// true：有错误
        List<String> collect = Arrays.stream(bulk.getItems()).map(item -> {
            return item.getId();
        }).collect(Collectors.toList());
        String s = bulk.toString();
        System.out.println("商品上架完成：{}，返回数据：{}" + collect + s);

        return b;
    }
}
