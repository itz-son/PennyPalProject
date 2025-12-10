package pennypal.controller;

import pennypal.AppState;
import pennypal.model.User;

import java.util.UUID;

/**
 * Handles user account creation/login.
 */
public class AccountController {

    private final AppState appState = AppState.getInstance();

    public User createAccount(String email, String name) {
        User user = new User(UUID.randomUUID().toString(), name, email, 0.0);
        appState.setCurrentUser(user);
        return user;
    }

    public boolean login(String email) {
        // Simple placeholder login: creates a user with given email.
        User user = new User(UUID.randomUUID().toString(), "User", email, 0.0);
        appState.setCurrentUser(user);
        return true;
    }
}
