package Service;

import dao.PlayerDAO;
import model.Player;
import service.interface.IPlayerService;

import java.util.ArrayList;
import java.util.List;

public class PlayerService implements IPlayerService {

    private final PlayerDAO dao = new PlayerDAO();
    private final String filename = "CT.DAT";
    private List<Player> players;

    public PlayerService() {
        players = dao.readFile(filename);
        if (players == null) players = new ArrayList<>();
    }

    @Override
    public void add(Player p) {
        players.add(p);
        dao.writeFile(filename, players);
    }

    @Override
    public List<Player> getAll() {
        return players;
    }

    @Override
    public Player findById(int id) {
        for (Player p : players)
            if (p.getId() == id)
                return p;
        return null;
    }

    @Override
    public int generateId() {
        if (players.isEmpty()) return 100;
        return players.get(players.size() - 1).getId() + 1;
    }
}
