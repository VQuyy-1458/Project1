package Service.Interface_;

import model.Assignment;

import java.util.List;

public interface IAssignmentService {
    void add(Assignment a);
    List<Assignment> getAll();
    void sortByPlayerName();
    void sortByMatchesDesc();
}
