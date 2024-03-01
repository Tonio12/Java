package tonilearnsjava;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ISaveable> players = new ArrayList<>();
        var player1  = new Player("Goku",100, 100 );
        var monster = new Monster("Dracula", 0, 200);
        players.add(player1);
        players.add(monster);

        for(ISaveable player : players){
            if(player instanceof Player ply){
                ply.setWeapon("Sword");
            }
            System.out.println(player.toString());
            System.out.println(player.write());
        }



    }
}
