package OdevOnbir;

public class GameManager {

    //private instance defined
    private  static GameManager instance;

    //private constructor created
    private GameManager() {
        System.out.println("GameManager is created");

    }

    // to call instance from outside
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
}
