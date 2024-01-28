package com.djourov.bankapp.repository;

import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.entity.enums.ProductName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product getProductByName(ProductName name);
}
