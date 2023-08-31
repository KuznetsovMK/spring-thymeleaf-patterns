package ru.gb.gbthymeleaf.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbthymeleaf.entity.security.Authority;

public interface AuthorityDao extends JpaRepository<Authority, Long> {
}
