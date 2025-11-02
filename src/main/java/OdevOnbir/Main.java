package OdevOnbir;

public class Main {

    public static void main(String[] args) {

        GameManager gameManager = GameManager.getInstance();
        System.out.println(gameManager);

        GameCharacter fighter1 = new GameCharacter.GameCharacterBuilder("Michelangelo")
                .weapon("Nunchaku")
                .strength(3)
                .build();
        GameCharacter fighter2 = new GameCharacter.GameCharacterBuilder("Donatello")
                .weapon("Bo staff")
                .strength(4)
                .build();

        System.out.println("1. Fighter:" + fighter1);
        System.out.println("2. Fighter:" + fighter2);

    }
}
