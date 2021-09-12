package edu.asoldatov.salary.repository;

import edu.asoldatov.salary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
