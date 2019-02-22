package api.managesoccer.repository;

import api.managesoccer.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    @Query("select t from Score t where score1 =:score1 and score2 =:score2 and id_match =:idMatch")
    Score findByScore(@Param("score1") int score1, @Param("score2") int score2, @Param("idMatch") int idMatch);

    @Query("select t from Score t where isWin =1 and id_match =:idMatch")
    Score getScoreWin(@Param("idMatch") int idMatch);

    @Query("select t from Score t where id_match =:idMatch")
    List<Score> getListScore(@Param("idMatch") int idMatch);
}
