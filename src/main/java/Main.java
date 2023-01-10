import dtu.ws.fastmoney.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankServiceService().getBankServicePort();
        User user = new User();
        user.setCprNumber("1234561234");
        user.setFirstName("Testy");
        user.setLastName("McTestface");
        try {
            String response = bank.createAccountWithBalance(user, new BigDecimal(1000));
            System.out.println(response);
            Account account = bank.getAccount(response);
            System.out.println(account.getUser().getFirstName());
            bank.retireAccount(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
