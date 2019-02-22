package api.managesoccer.repository;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;


import api.managesoccer.model.*;
@Repository

public interface BetsRepository extends JpaRepository<Bets, Integer> {
    @Query("select count(ds.playerId) from Bets ds where ds.id_score =:score_id")
    int countTotalPlayerForScore(@Param("score_id") int score_id);

    @Query("select playerId from Bets where id_score =:score_id")
    List<Integer> getListPlayer(@Param("score_id") int score_id);

}
