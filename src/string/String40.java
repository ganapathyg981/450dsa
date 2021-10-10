package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class String40 {
    public static void main(String[] args) {
        System.out.println(runCustomerSimulation(2, "ABBAJJKZKZ"));
        System.out.println(runCustomerSimulation(3, "GACCBDDBAGEE"));
        System.out.println(runCustomerSimulation(3, "GACCBGDDBAEE"));
        System.out.println(runCustomerSimulation(1, "ABCBCA"));
        System.out.println(runCustomerSimulation(1, "ABCBCADEED"));
    }
    public static int runCustomerSimulation(int computers,String customers){
        int vacantComputers=computers;
        Character currentCustomer;
        List <Character> usingComputer=new ArrayList<>();
        Set<Character> customersWithoutComputer=new HashSet<>();
        for(int i=0;i<customers.length();i++){
            currentCustomer=Character.valueOf(customers.charAt(i));
            if(usingComputer.contains(currentCustomer)){
                usingComputer.remove(currentCustomer);
                vacantComputers++;
            }
            else{
                if(vacantComputers>0){
                    usingComputer.add(currentCustomer);
                    vacantComputers--;
                }
                else
                    customersWithoutComputer.add(currentCustomer);
            }
        }
        return customersWithoutComputer.size();
    }

}
