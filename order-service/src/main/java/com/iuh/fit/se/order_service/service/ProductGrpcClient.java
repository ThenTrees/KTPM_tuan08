package com.iuh.fit.se.order_service.service;

import com.iuh.fit.se.grpc.product.GetProductRequest;
import com.iuh.fit.se.grpc.product.ProductResponse;
import com.iuh.fit.se.grpc.product.ProductServiceGrpc;
import io.grpc.Channel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ProductGrpcClient {

    private ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

    @GrpcClient("product-service")
    public void setProductServiceBlockingStub(Channel channel) {
        this.productServiceBlockingStub = ProductServiceGrpc.newBlockingStub(channel);
    }

    public ProductResponse GetProduct(String id){
        GetProductRequest request = GetProductRequest.newBuilder().setId(id).build();
        return productServiceBlockingStub.getProduct(request);
    }
}