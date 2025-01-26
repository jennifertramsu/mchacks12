package mchacks.mchacks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mchacks.mchacks.dao.PatientDao;
import mchacks.mchacks.dao.PlayerDao;
import mchacks.mchacks.model.Patient;
import mchacks.mchacks.model.Player;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {
    @Autowired
    private PlayerDao playerDao;
    @Autowired
    private PatientDao patientDao;

    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Transactional
    public Player createPlayer(Patient patient) {
        Patient p = patientDao.findPatientById(patient.getId());
        Player player = new Player(p);
        playerDao.save(player);
        return player;
    }

    @Transactional
    public Player getPlayer(String id) {
        return playerDao.findPlayerById(id);
    }

    @Transactional
    public void updatePlayer(String id, int score) {
        Player player = playerDao.findPlayerById(id);
        player.setScore(score);
        playerDao.save(player);
    }
}
