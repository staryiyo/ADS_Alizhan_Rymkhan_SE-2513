import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AccStorage storage = new AccStorage();
//        storage.add_acc("Alizhan", 1, 1000000);
//        storage.add_acc("Adilbek", 2, 0);
//        storage.add_acc("Dimash", 3, 500);
//        storage.add_acc("Rinat", 4, 67);
//        storage.add_acc("Yerketay", 5, 100);
//        storage.add_acc("Aldiyar", 6, 10000);
//        storage.add_acc("Agzam", 7, 100000);
        //System.out.println("Account list: ");
        //storage.display_acc();
        //storage.search_acc("Alizhan");

//        storage.deposit("Alizhan", 50000);
//        storage.withdraw("Adilbek", 500); // insufficient funds
//        storage.withdraw("Dimash", 300);

        Scanner sc = new Scanner(System.in);

        storage.add_acc("Alizhan", 1, 5000);
        storage.add_acc("Tair", 2, 10000);

        while (true){
            System.out.println("\n --- Banking System menu ---");
            System.out.println("1. User Menu (ATM/Bank) ");
            System.out.println("2. Admin Menu");
            System.out.println("3. Show Physical Storage (task6) ");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int mainchoice = sc.nextInt();
            sc.nextLine();

            if (mainchoice == 0){
                break;
            }

            switch (mainchoice) {
                case 1:
                    System.out.println("\n1. Deposit\n2. Withdraw\n3. Last Transaction\n4. Undo Last\n5. Request Account Opening");
                    int userChoice = sc.nextInt();
                    sc.nextLine();

                    if (userChoice == 1) {
                        System.out.print("Enter username: ");
                        String name = sc.nextLine();
                        System.out.print("Amount to deposit: ");
                        int amount = sc.nextInt();
                        storage.deposit(name, amount);

                    } else if (userChoice == 2) {
                        // ДОБАВИЛИ ВЫВОД СРЕДСТВ
                        System.out.print("Enter username: ");
                        String name = sc.nextLine();
                        System.out.print("Amount to withdraw: ");
                        int amount = sc.nextInt();
                        storage.withdraw(name, amount);

                    } else if (userChoice == 3) {
                        storage.displaylasttransaction();

                    } else if (userChoice == 4) {
                        storage.undolasttransaction();

                    } else if (userChoice == 5) {
                        System.out.print("Enter your name for the request: ");
                        String name = sc.nextLine();
                        storage.requestAccOpening(name);
                    }
                    break;

                case 2:
                    System.out.println("\n1. Process Account Request\n2. View Account Requests\n3. Process Bill\n4. View Bills");
                    int adminChoice = sc.nextInt();
                    sc.nextLine();

                    if (adminChoice == 1) {
                        System.out.print("Assign ID: ");
                        int id = sc.nextInt();
                        System.out.print("Initial Balance: ");
                        int bal = sc.nextInt();
                        storage.processAccountRequest(id, bal);
                    } else if (adminChoice == 2) {
                        storage.displayAccRequests();
                    } else if (adminChoice == 3) {
                        storage.displaybills();
                    } else if (adminChoice ==4) {
                        storage.processbill();
                    }
                    break;

                case 3:
                    storage.showPhysicalStorage();
                    break;
            }
        }
        System.out.println("Program closed.");
    }
}

