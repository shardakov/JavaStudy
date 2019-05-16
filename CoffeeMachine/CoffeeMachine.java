
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int coffee_beans = 120;
        int disposable_cups = 9;
        int money = 550;

        String inputText = "";
        System.out.println();
        while(true){
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            inputText = scanner.next();
            System.out.println();
            if(inputText.equals("buy")){
                System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String inputComm = scanner.next();
                if (inputComm.equals("1")){
                    if(water - 250 > 0 && coffee_beans - 16 > 0 && disposable_cups - 1 > 0){
                        System.out.println("I have enough resources, making you a coffee!");
                        water = water - 250;
                        coffee_beans = coffee_beans - 16;
                        disposable_cups = disposable_cups - 1;
                        money = money + 4;
                    }
                    else{
                        if(water - 250 <= 0){
                            System.out.println("Sorry, not enough water!");
                        }
                        else if (coffee_beans - 16 <= 0){
                            System.out.println("Sorry, not enough coffee beans!");
                        }
                        else if (disposable_cups - 1 <= 0){
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                    }
                }
                else if (inputComm.equals("2")){
                    if(water - 350 > 0 && milk-75 > 0 && coffee_beans - 20 > 0 && disposable_cups - 1 > 0){
                        System.out.println("I have enough resources, making you a coffee!");
                        water = water - 350;
                        milk = milk - 75;
                        coffee_beans = coffee_beans - 20;
                        disposable_cups = disposable_cups - 1;
                        money = money + 7;
                    }
                    else{
                        if(water - 350 <= 0){
                            System.out.println("Sorry, not enough water!");
                        }
                        else if (milk - 75 <= 0){
                            System.out.println("Sorry, not enough milk!");
                        }
                        else if (coffee_beans - 20 <= 0){
                            System.out.println("Sorry, not enough coffee beans!");
                        }
                        else if (disposable_cups - 1 <= 0){
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                    }
                }
                else if (inputComm.equals("3")){
                    if(water - 200 > 0 && milk-100 > 0 && coffee_beans - 12 > 0 && disposable_cups - 1 > 0){
                        System.out.println("I have enough resources, making you a coffee!");
                        water = water - 200;
                        milk = milk - 100;
                        coffee_beans = coffee_beans - 12;
                        disposable_cups = disposable_cups - 1;
                        money = money + 6;
                    }
                    else{
                        if(water - 200 <= 0){
                            System.out.println("Sorry, not enough water!");
                        }
                        else if (milk - 100 <= 0){
                            System.out.println("Sorry, not enough milk!");
                        }
                        else if (coffee_beans - 12 <= 0){
                            System.out.println("Sorry, not enough coffee beans!");
                        }
                        else if (disposable_cups - 1 <= 0){
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                    }
                }
                else if(inputComm.equals("back")){
                    continue;
                }
            } 
            else if (inputText.equals("fill")){
                System.out.print("Write how many ml of water do you want to add: ");
                water += scanner.nextInt();
                System.out.print("Write how many ml of milk do you want to add: ");
                milk += scanner.nextInt();
                System.out.print("Write how many grams of coffee beans do you want to add: ");
                coffee_beans += scanner.nextInt();
                System.out.print("Write how many disposable cups of coffee do you want to add: ");
                disposable_cups += scanner.nextInt();
            }
            else if (inputText.equals("take")){
                System.out.println("I gave you $" + money);
                money = 0;
            }
            else if (inputText.equals("remaining")){
                System.out.println("The coffee machine has:");
                System.out.println(water + " of water");
                System.out.println(milk + " of milk");
                System.out.println(coffee_beans + " of coffee beans");
                System.out.println(disposable_cups + " of disposable cups");
                System.out.println(money + " of money");
            }
            else if (inputText.equals("exit")){
                break;
            }
            else{
                System.out.println("I don't know this command!");
            }
            System.out.println();
        }
    }
}
