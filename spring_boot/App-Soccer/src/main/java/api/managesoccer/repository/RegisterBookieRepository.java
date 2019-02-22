package api.managesoccer.repository;

import api.managesoccer.model.RegisterBookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterBookieRepository extends JpaRepository<RegisterBookie, Integer> {
}
