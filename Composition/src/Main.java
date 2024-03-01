public class Main {
    public static void main(String[] args) {
        SmartChicken  kitchen = new SmartChicken();

        kitchen.setKitchenState(true,false,true);
        kitchen.doKitchenWork();

//        kitchen.getBrewMaster().setHasWorkToDo(true);
//        kitchen.getDishWasher().setHasWorkToDo(true);
//        kitchen.getIceBox().setHasWorkToDo(true);
//
//        kitchen.getBrewMaster().brewCoffee();
//        kitchen.getDishWasher().doDishes();
//        kitchen.getIceBox().orderFood();
    }
}
