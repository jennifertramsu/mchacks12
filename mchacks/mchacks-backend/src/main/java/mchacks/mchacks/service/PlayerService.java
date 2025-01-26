package mchacks.mchacks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mchacks.mchacks.dao.PlayerDao;
import mchacks.mchacks.model.Player;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {
    @Autowired
    private PlayerDao playerDao;

    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Transactional
    public void addPlayer(Player player) {
        playerDao.save(player);
    }

    @Transactional
    public void updatePlayer(Player player) {
        playerDao.save(player);
    }
}
