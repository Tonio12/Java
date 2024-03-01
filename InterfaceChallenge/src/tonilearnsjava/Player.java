package tonilearnsjava;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{
    private String name;
    private String weapon;
    int hitPoints;
    int strength;


    public Player(String name,  int hitPoints, int strength){
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return  hitPoints;
    }

    public  int getStrength(){
        return strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player{name='" + getName() + "', hitPoints=" + getHitPoints() + ", strength=" + getStrength() + ", weapon='" + weapon + "'}";
    }


    public List<String> write(){
        List<String> players = new ArrayList<>();
        players.add(toString());
        return players;
    }

    public void read(List<String> item){
        if(item != null  && item.size() > 0){
            item.add(toString());
        }
    }
}
