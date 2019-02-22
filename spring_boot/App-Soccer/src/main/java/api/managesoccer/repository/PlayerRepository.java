package api.managesoccer.repository;

import api.managesoccer.model.Player;
import api.managesoccer.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query("select n from Player n where n.username =:username")
    Player findByUserName(@Param("username") String username);


}
