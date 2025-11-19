package Service;

import dao.AssignmentDAO;
import model.Assignment;
import service.interface.IAssignmentService;

import java.util.ArrayList;
import java.util.List;

public class AssignmentService implements IAssignmentService {

    private final AssignmentDAO dao = new AssignmentDAO();
    private final String filename = "PCCT.DAT";
    private List<Assignment> assignments;

    public AssignmentService() {
        assignments = dao.readFile(filename);
        if (assignments == null) assignments = new ArrayList<>();
    }

    @Override
    public void add(Assignment a) {
        assignments.add(a);
        dao.writeFile(filename, assignments);
    }

    @Override
    public List<Assignment> getAll() {
        return assignments;
    }

    @Override
    public void sortByPlayerName() {
        assignments.sort((a, b) ->
                a.getPlayer().getName().compareToIgnoreCase(b.getPlayer().getName())
        );
        dao.writeFile(filename, assignments);
    }

    @Override
    public void sortByMatchesDesc() {
        assignments.sort((a, b) -> b.getMatches() - a.getMatches());
        dao.writeFile(filename, assignments);
    }
}
