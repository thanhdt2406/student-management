package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users;

    public UserDAO() {
        this.users = new ArrayList<>();
    }

    public UserDAO(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
