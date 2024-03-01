package tonilearnsjava;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int  hitPoints;
    private int strength;

    public Monster(String  name, int hitPoints, int strength){
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



    @Override
    public String toString() {
        return "Monster{name='" + getName() + "', hitPoints=" + getHitPoints() + ", strength=" + getStrength() + "}";
    }





    public List<String> write(){
        List<String> monster = new ArrayList<>();
        monster.add(toString());
        return monster;
    }

    public void read(List<String> monsterList){
        if(monsterList != null  && monsterList.size() > 0){
            monsterList.add(toString());
        }
    }
}
