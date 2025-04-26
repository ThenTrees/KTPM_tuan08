package com.iuh.fit.se.order_service.grpc;

import com.iuh.fit.se.grpc.product.GetProductRequest;
import com.iuh.fit.se.grpc.product.ProductServiceGrpc;
import com.iuh.fit.se.order_service.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductGrpcClient {

    private ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

    public ProductGrpcClient(@GrpcClient("product-service") ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub){
            this.productServiceBlockingStub = productServiceBlockingStub;
    }

    public ProductResponseDto getProduct(String id) {
        GetProductRequest request = GetProductRequest.newBuilder()
                .setId(id)
                .build();
        var product = productServiceBlockingStub.getProduct(request);

    return ProductResponseDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .build();
    }
}
