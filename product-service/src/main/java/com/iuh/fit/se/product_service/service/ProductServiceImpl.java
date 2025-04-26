package com.iuh.fit.se.product_service.service;

import com.iuh.fit.se.grpc.product.*;
import com.iuh.fit.se.product_service.model.Product;
import com.iuh.fit.se.product_service.repository.ProductRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepository productRepository;

    @Override
    public void getProduct(GetProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        Product product = productRepository.findById(request.getId()).orElse(null);
        if (product == null) {
            responseObserver.onError(new RuntimeException("Product not found"));
        }

        ProductResponse response = ProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setPrice(product.getPrice())
                .setStock(product.getStock())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void deleteProduct(DeleteProductRequest request, StreamObserver<DeleteProductResponse> responseObserver) {
        Product product = productRepository.findById(request.getId()).orElse(null);
        if (product == null) {
            responseObserver.onError(new RuntimeException("Product not found"));
        }

        productRepository.deleteById(request.getId());
        DeleteProductResponse response = DeleteProductResponse.newBuilder()
                .setSuccess(true)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void listProducts(ListProductsRequest request, StreamObserver<ListProductsResponse> responseObserver) {
        List<Product> products = productRepository.findAll();

        ListProductsResponse response = ListProductsResponse.newBuilder()
                .addAllProducts(products.stream().map(
                        product -> {
                            return ProductResponse.newBuilder()
                           .setId(product.getId())
                           .setName(product.getName())
                           .setDescription(product.getDescription())
                           .setPrice(product.getPrice())
                           .setStock(product.getStock())
                           .build();
                        }
                ).collect(Collectors.toList()))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
