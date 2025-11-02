package OdevOnbir;

public class GameCharacter {

    private final String name;
    private final String weapon;
    private final int strength;

    //only builder can reach constructor
    private GameCharacter(GameCharacterBuilder builder) {
        this.name = builder.name;
        this.weapon = builder.weapon;
        this.strength = builder.strength;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Weapon: " + weapon + "\n" +
                "Strength: " + strength + "\n";
    }

    public static class GameCharacterBuilder {

        private final String name;
        private String weapon;
        private int strength;

        public GameCharacterBuilder (String name) {
            this.name = name;
        }

        public GameCharacterBuilder weapon(String weapon) {
            this.weapon = weapon;
            return this;
        }

        public GameCharacterBuilder strength(int strength) {
            this.strength = strength;
            return this;
        }

        // creating object of Game Character
        public GameCharacter build() {
            return new GameCharacter(this);

        }

    }

}
