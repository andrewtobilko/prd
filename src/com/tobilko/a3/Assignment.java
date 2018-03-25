package com.tobilko.a3;

import com.intersys.globals.Connection;
import com.intersys.globals.ConnectionContext;
import com.intersys.globals.NodeReference;

import java.util.Scanner;


/**
 * Для глобалу з л/р №2 розробити програму на мові високого рівня
 * для перегляду та зміни значень вузлів та індексів глобала.
 */
public class Assignment {

    private static final NodeReference reference;
    private static final Scanner scanner = new Scanner(System.in);

    static {
        final String namespace = "ANIMALS";
        final String user = "Andrew";
        final String password = "Tobilko";
        final String globalName = "Animals";
        final Connection connection;

        (connection = ConnectionContext.getConnection()).connect(namespace, user, password);
        reference = connection.createNodeReference(globalName);

        Runtime.getRuntime().addShutdownHook(new Thread(connection::close));
    }

    public static void main(String[] args) {
        boolean restartSession;
        do {
            System.out.println("Do you want to get [0] or edit [1] the global?");
            int action = Integer.valueOf(scanner.nextLine());

            if (action != 0 && action != 1) {
                System.out.println("Incorrect choice. I hope you'll be more accurate in typing next time.");
            } else {
                startSession(action);
            }

            System.out.println("The session is over. Would you like to start a new session [true] or close the app [false]?");
            restartSession = Boolean.valueOf(scanner.nextLine());
        } while (restartSession);
    }

    private static void startSession(int type) {
        final String referenceName = reference.getName();

//        if (type == 0) {
//            System.out.println(String.format("Fetching data for '%s'...", referenceName));
//
//            System.out.println(reference.getObject("ages"));
//            System.out.println(reference.getString("aliases"));
//            System.out.println(reference.getList("names"));
//            System.out.println(reference.getString("title"));
//            System.out.println(reference.getInt("number"));
//¬≤
//        } else {
//            System.out.println("Which --- do you want to edit?");
//            final String s = scanner.nextLine();
//
//        }

    }

}
