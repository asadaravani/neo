package org.example.onlineshop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
interface ProductRepository extends JpaRepository<Product, Long> {


}
