package Service.Interface_;

import java.util.List;

public interface IEntityService<T> {
    void add(T t);
    List<T> getAll();
    T findById(int id);
}

