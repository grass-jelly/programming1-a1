package rmit;

import rmit.singleton.*;
import rmit.command.CustomerSetNameCommand;
import rmit.decorator.Decorator;
import rmit.decorator.TimeDrawingDecorator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        VietLott vietLott = VietLott.getInstance();
        vietLott.start();
    }
}
