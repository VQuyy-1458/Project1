package Service;

import dao.PositionDAO;
import model.Position;
import service.interface.IPositionService;

import java.util.ArrayList;
import java.util.List;

public class PositionService implements IPositionService {

    private final PositionDAO dao = new PositionDAO();
    private final String filename = "VITRI.DAT";
    private List<Position> positions;

    public PositionService() {
        positions = dao.readFile(filename);
        if (positions == null) positions = new ArrayList<>();
    }

    @Override
    public void add(Position p) {
        positions.add(p);
        dao.writeFile(filename, positions);
    }

    @Override
    public List<Position> getAll() {
        return positions;
    }

    @Override
    public Position findById(int id) {
        for (Position p : positions)
            if (p.getId() == id)
                return p;
        return null;
    }

    @Override
    public int generateId() {
        if (positions.isEmpty()) return 100;
        return positions.get(positions.size() - 1).getId() + 1;
    }
}
