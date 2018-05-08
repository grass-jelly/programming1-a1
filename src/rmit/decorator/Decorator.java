package rmit.decorator;

import rmit.Customer;

import java.util.ArrayList;
import java.util.List;

public interface Decorator {
    List<Customer> customers = new ArrayList<>();
    public int[] generate();
}
