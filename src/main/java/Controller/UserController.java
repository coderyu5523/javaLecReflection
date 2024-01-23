package Controller;

import dao.UserDAO;

public class UserController {
    private UserDAO dao ;

    public UserController(UserDAO dao) {
        this.dao = dao;
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public void insert(){
        System.out.println("controller :insert");
        dao.insert("oh","6677","01055114477");
    }
    public void delete(){
        System.out.println("controller : delete");
        dao.delete(5);
    }
    public void update(){
        System.out.println("controller : update");
        dao.update("1133","01044445555",5);
    }
}
