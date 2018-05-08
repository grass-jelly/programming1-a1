package rmit.command;

import rmit.Customer;
import rmit.command.Command;

public class CustomerSetNameCommand implements Command {
    protected Customer customer;
    protected String newName;

    public CustomerSetNameCommand(Customer customer, String newName) {
        this.customer = customer;
        this.newName = newName;
    }

    @Override
    public void execute() {
        customer.setName(newName);
    }
}
