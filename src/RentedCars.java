import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class RentedCars {

    private ArrayList<String> plates;
    public RentedCars(){
        this.plates=new ArrayList<>();
    }
    public int getSize(){
        return this.plates.size();
    }
    public ArrayList<String> getPlates(){
        return this.plates;
    }

}