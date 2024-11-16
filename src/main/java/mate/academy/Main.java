package mate.academy;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.AuthenticationServiceImpl;
import mate.academy.service.OrderService;
import mate.academy.service.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static final String BOB = "bob";

    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user;
        try {
            user = authenticationService.login(BOB, "1234");
        } catch (AuthenticationException e) {
            log.error("Authentication exception thrown for user with login: \"{}\"", BOB);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
