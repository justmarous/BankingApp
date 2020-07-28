import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branchArrayList;

    public Bank(ArrayList<Branch> branchArrayList) {
        this.branchArrayList = branchArrayList;
    }

    public ArrayList<Branch> getBranchArrayList() {
        return branchArrayList;
    }

    public void addBranch(Branch branch)
    {
        branchArrayList.add(branch);
    }

    public void showBranches()
    {
        for(int i=0;i<branchArrayList.size();i++)
        {
            System.out.println("Branch no "+(i+1)+": "+branchArrayList.get(i).getBranchName());
        }
    }
}
