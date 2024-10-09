package com.github.syndexmx.demobudget.repositories;

import com.github.syndexmx.demobudget.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<UserEntity, String> {
}
