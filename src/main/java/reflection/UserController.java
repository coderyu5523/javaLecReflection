package reflection;
import dao.UserDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserController {
    private UserDAO dao ;


    @RequestMapping(uri="/insert")
    public void insert(){
        System.out.println("controller :insert");
        dao.insert("oh","6677","01055114477");
    }
    @RequestMapping(uri="/delete")
    public void delete(){
        System.out.println("controller : delete");
        dao.delete(5);
    }
    @RequestMapping(uri="/update")
    public void update(){
        System.out.println("controller : update");
        dao.update("1133","01044445555",5);
    }
}
