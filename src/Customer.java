import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double firstTransaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();

        transactions.add(firstTransaction);
    }

    public void addTransaction(double newTransaction)
    {
        if(checkTransaction(newTransaction))
        {
            transactions.add(newTransaction);
            System.out.println("Transaction added in the system");
        }
        else System.out.println("This transaction is already in the system");
    }

    public boolean checkTransaction(double newTransaction)
    {
            for(int i =0;i<transactions.size();i++)
            {
                if(newTransaction==transactions.get(i))return false;
            }

        return true;
    }

    public String getName() {
        return name;
    }

    public void printTransactions()
    {
        for(int i = 0;i<transactions.size();i++)
        {
            System.out.println((i+1)+": "+transactions.get(i));
        }
    }
}
