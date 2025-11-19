package Service.Interface_;

import model.Position;

public interface IPositionService extends IEntityService<Position> {
    int generateId();
}
