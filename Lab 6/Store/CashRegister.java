  
import java.text.*;

public class CashRegister {
    private double cash;

    public CashRegister() {
        cash = 0;
    }

    public void add(double money) {
        cash = cash + money;
    }

    @Override
    public String toString() {
        return "Cash: $" + formatted(cash);
    }

    private String formatted(double amount) {
        return new DecimalFormat("###,##0.00").format(amount);
    }
}
