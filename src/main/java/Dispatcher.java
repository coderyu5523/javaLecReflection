import Controller.UserController;

public class Dispatcher {
    private UserController con ;

    public Dispatcher(UserController con) {
        this.con = con;
    }


    public void route(String url){
        if(url.equals("/insert")){
            con.insert();
        }else if(url.equals("/delete")){
            con.delete();
        }else if(url.equals("/update")){
            con.update();
        }


    }

}
