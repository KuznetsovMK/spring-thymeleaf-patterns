package ru.gb.gbthymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbthymeleaf.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {
}
