package rmit.command;

import rmit.Shop;

public class ShopSetOwnerCommand implements Command {
    protected Shop shop;
    protected String newOwner;

    public ShopSetOwnerCommand(Shop shop, String newOwner) {
        this.shop = shop;
        this.newOwner = newOwner;
    }

    @Override
    public void execute() {
        shop.setOwner(newOwner);
    }
}
