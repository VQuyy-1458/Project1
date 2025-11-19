package Service.Interface_;

import model.Player;

public interface IPlayerService extends IEntityService<Player> {
    int generateId();
}

