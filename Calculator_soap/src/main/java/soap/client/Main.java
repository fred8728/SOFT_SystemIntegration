package soap.client;

import org.apache.axis.AxisFault;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws RemoteException, ServiceException {

        CalculatorLocator locater = new CalculatorLocator();
        CalculatorSoap12Stub calculator = (CalculatorSoap12Stub) locater.getCalculatorSoap12();

        var add = calculator.add(5,7);
        System.out.println("Addition: " + add);

        var subtract = calculator.subtract(30, 70);
        System.out.println("Subtraction: " + subtract);

        var division = calculator.divide(600,300);
        System.out.println("Division: " + division);

        var multiply = calculator.multiply(60,55);
        System.out.println("Multiplication: " + multiply);
    }
}
