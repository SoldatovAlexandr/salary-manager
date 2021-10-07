package edu.strongsubgroup.salary.repository;

import edu.strongsubgroup.salary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
