package edu.strongsubgroup.salary.repository;

import edu.strongsubgroup.salary.common.UserRole;
import edu.strongsubgroup.salary.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(UserRole name);

    @Query(value = "SELECT r from Role r WHERE r.name in :roles")
    Set<Role> findAllByName(@Param("roles") List<UserRole> roles);
}
