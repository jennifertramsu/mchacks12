package mchacks.mchacks.dao;

import org.springframework.data.repository.CrudRepository;

import mchacks.mchacks.model.Player;

public interface PlayerDao extends CrudRepository<Player, String> {
    Player findPlayerById(String patient_id);
}
