package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.Role;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends BaseRepository<Role, UUID> {
    Optional<Role> findByName(String name);
    
    
    @Query("SELECT r FROM Role r WHERE r.name NOT IN ('ADMIN', 'SUPER_ADMIN','CLIENT')")
    List<Role> findAllExcludingAdminAndSuperAdminAndClient();
}
