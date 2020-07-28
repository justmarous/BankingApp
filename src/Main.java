
    /*

    - bank class with array of branches
    - each branch should have array list of customers
    - each customer should have list of trasactions (double)
    - Customer: name, array list of transactions
    - Branch: ability to add new customer with its name and the initial transaction amount, ability to add new transaction for customer, also adding new branch
    - Bank: add new branch, add a customer with initial amount, ability to add transaction of customer, list of customers for branch
    - HINT: data validation for transactions - if it exists or it doesnt

    */


    import java.util.ArrayList;
    import java.util.Scanner;

    public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Bank pekao = new Bank(new ArrayList<Branch>());

    public static void main(String[] args) {

        initializeDefaultBank();

        int choice = 0;

        while(choice!=5)
        {
            printInstruction();
            choice = scanner.nextInt();
            switch(choice)
            {
                case -1:
                    System.out.println("Show transaction of the client...");
                    showTransactions();
                    break;
                case 0:
                    System.out.println("Adding new client...");
                    addClient();
                    break;
                case 1:
                    System.out.println("Adding new transaction to a client...");
                    addTransaction();
                    break;
                case 2:
                    System.out.println("Showing branches...");
                    showBranches();
                    break;
                case 3:
                    System.out.println("Adding new branch...");
                    addBranch();
                    break;
                case 4:
                    System.out.println("Showing clients...");
                    showClients();
                    break;
                case 5:
                    System.out.println("Quitting the program");
                    break;
            }

        }

    }

    public static void printInstruction()
    {
        System.out.println("\n\n0 for adding new client to exisiting branch\n" +
                "1 for adding new transaction to client\n2 to show all branches\n3 to add branches\n4 to print all clients\n" +
                "5 to quit the application");
    }

    public static void initializeDefaultBank()
    {

        Branch warsaw = new Branch("Warsaw",new ArrayList<Customer>());

        pekao.addBranch(warsaw);

        Customer marek = new Customer("Marek",3030);
        marek.addTransaction(322);
        marek.addTransaction(929);

        Customer darek = new Customer("Darek",220);
        darek.addTransaction(13);
        darek.addTransaction(29);

        warsaw.addCustomer(marek);
        warsaw.addCustomer(darek);

    }

    public static void showBranches()
    {
       pekao.showBranches();
    }

    public static void showClients()
    {
        for(int i=0;i<pekao.getBranchArrayList().size();i++)
        {
            System.out.println("Branch no "+(i+1)+": "+pekao.getBranchArrayList().get(i).getBranchName()+"\nClients:");
            for(int j=0;j<pekao.getBranchArrayList().get(i).getCustomerArrayList().size();j++)
            {
                System.out.println("Client "+(j+1)+": "+pekao.getBranchArrayList().get(i).getCustomerArrayList().get(j).getName());
            }
        }
    }

    public static void addClient()
    {
        System.out.println("What is the name of the client?\r");
        scanner.nextLine();

        String name = scanner.nextLine();
        System.out.println(name+" added. What should be this clients first transaction?\r");

        Double firstTransaction = scanner.nextDouble();
        System.out.println("Transaction added");

        System.out.println("Which branch the client should be assigned to?");

        showBranches();

        int choice = scanner.nextInt();
        System.out.println("You have chosen branch: "+pekao.getBranchArrayList().get(choice-1).getBranchName());

        Customer customer = new Customer(name,firstTransaction);
        pekao.getBranchArrayList().get(choice-1).addCustomer(customer);
    }
    public static void addTransaction()
    {
        System.out.println("Which branch are you in?");
        showBranches();

        int choice = scanner.nextInt();
        System.out.println("You have chosen branch: "+pekao.getBranchArrayList().get(choice-1).getBranchName());

        System.out.println("Choose the client:");

        for(int i = 0; i <pekao.getBranchArrayList().get(choice-1).getCustomerArrayList().size();i++)
        {
            System.out.println("Client no "+(i+1)+": "+pekao.getBranchArrayList().get(choice-1).getCustomerArrayList().get(i).getName());
        }

        choice = scanner.nextInt();

        System.out.println("What transaction would you like to add?");
        double newTransaction = scanner.nextDouble();

        pekao.getBranchArrayList().get(choice-1).getCustomerArrayList().get(choice-1).addTransaction(newTransaction);
    }

        public static void showTransactions()
        {
            System.out.println("Which branch are you in?");
            showBranches();

            int choice = scanner.nextInt();
            System.out.println("You have chosen branch: "+pekao.getBranchArrayList().get(choice-1).getBranchName());

            System.out.println("Choose the client:");


            for(int i = 0; i <pekao.getBranchArrayList().get(choice-1).getCustomerArrayList().size();i++)
            {
                System.out.println("Client no "+(i+1)+": "+pekao.getBranchArrayList().get(choice-1).getCustomerArrayList().get(i).getName());
            }

            choice = scanner.nextInt();
            pekao.getBranchArrayList().get(choice-1).getCustomerArrayList().get(choice-1).printTransactions();


        }
    public static void addBranch()
    {
        System.out.println("What should be new branch named?");
        scanner.nextLine();
        String brancName = scanner.nextLine();

        System.out.println("Branch "+brancName+" has been created!");

        Branch newBranch = new Branch(brancName,new ArrayList<Customer>());
        pekao.addBranch(newBranch);
    }

}
