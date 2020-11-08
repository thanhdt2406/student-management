package dao.user_service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();

    boolean changePassword(int id,String password);

    User getUserInfor(int userID);
}
