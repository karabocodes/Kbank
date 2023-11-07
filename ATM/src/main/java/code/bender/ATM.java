package code.bender;

public class ATM {
    public static void main(String[] args) {
        welcomeMessage();
//        Menu menu = new Menu();
        Menu.displayMenu();
    }
    public static void welcomeMessage(){
        System.out.println("welcome to the Bank");
    }

}

