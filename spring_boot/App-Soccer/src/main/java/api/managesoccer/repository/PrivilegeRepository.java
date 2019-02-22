package api.managesoccer.repository;

import api.managesoccer.model.ManagePrivilege;
import api.managesoccer.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Score, Integer> {
    @Query("select m from ManagePrivilege m where role_id =:role_id and path =:path")
    ManagePrivilege findByRoleId(@Param("role_id") int role_id, @Param("path") String path);
}
