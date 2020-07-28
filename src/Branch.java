import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customerArrayList;


    public Branch(String branchName, ArrayList<Customer> customerArrayList) {
        this.branchName = branchName;
        this.customerArrayList = customerArrayList;
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public void addCustomer(Customer customer)
    {
        customerArrayList.add(customer);
    }
}
