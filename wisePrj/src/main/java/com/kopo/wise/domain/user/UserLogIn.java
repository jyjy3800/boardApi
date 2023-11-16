package com.kopo.wise.domain.user;
import java.util.ArrayList;
import java.util.List;

public class UserLogIn {
	private static List<Long> loggedInUsers = new ArrayList<>();

    public static boolean isAlreadyLoggedIn(Long memberId) {
        return loggedInUsers.contains(memberId);
    }

    public static void addLoggedInUser(Long memberId) {
        loggedInUsers.add(memberId);
    }

    public static void logout(Long memberId) {
        loggedInUsers.remove(memberId);
    }
}