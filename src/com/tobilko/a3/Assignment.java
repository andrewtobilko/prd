package com.tobilko.a3;

import com.intersys.globals.*;
import com.intersys.globals.impl.ValueListImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


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

    //        readValue(SupportedType.STRING, "area");
    //        readValue(SupportedType.INT, "section1", "cheetah");
    //        readValue(SupportedType.LIST, "section1", "popularNames");
    public static void main(String[] args) {
//        read();
//        editOrCreate();
        delete();
    }

    private static void editOrCreate() {
        System.out.print("Enter comma-separated keys: ");
        final String keys = scanner.nextLine();

        System.out.print("Enter the type [0 - INT, 1 - STRING, 2 - LIST]: ");
        final int typeIndex = Integer.valueOf(scanner.nextLine());

        System.out.print("Enter a new value: ");
        if (keys.contains(",")) {
            switch (SupportedType.values()[typeIndex]) {
                case INT:
                    reference.set(Integer.valueOf(scanner.nextLine()), (Object[]) keys.split(","));
                    break;
                case STRING:
                    reference.set(scanner.nextLine(), (Object[]) keys.split(","));
                    break;
                case LIST:
                    reference.set(conventArrayToValueList(scanner.nextLine().split(",")), (Object[]) keys.split(","));
                    break;
            }
        } else {
            switch (SupportedType.values()[typeIndex]) {
                case INT:
                    reference.set(Integer.valueOf(scanner.nextLine()), keys);
                    break;
                case STRING:
                    reference.set(scanner.nextLine(), keys);
                    break;
                case LIST:
                    reference.set(conventArrayToValueList(scanner.nextLine().split(",")), keys);
                    break;
            }
        }

    }

    private static ValueList conventArrayToValueList(String[] array) {
        final ValueListImpl list = new ValueListImpl();
        for (String s : array) {
            list.append(s);
        }
        return list;
    }

    private static void delete() {
        try {
            System.out.print("Enter comma-separated keys:");

            final String[] keys = scanner.nextLine().split(",");
            if (keys.length > 1) {
                reference.killNode((Object[]) keys);
            } else {
                reference.killNode((Object) keys);
            }
        } catch (GlobalsException exception) {
            System.out.println("Something went wrong. [You likely mistyped the type.]");
        }
    }

    private static void read() {
        try {

            System.out.print("Enter comma-separated keys: ");
            final String keys = scanner.nextLine();

            System.out.print("Enter the type [0 - INT, 1 - STRING, 2 - LIST]: ");
            final int typeIndex = Integer.valueOf(scanner.nextLine());

            if (keys.contains(",")) {
                readValue(SupportedType.values()[typeIndex], keys.split(","));
            } else {
                readValue(SupportedType.values()[typeIndex], keys);
            }

        } catch (GlobalsException exception) {
            System.out.println("Something went wrong. [You likely mistyped the type.]");
        }
    }

    private static void readValue(SupportedType type, String... keys) {
        switch (type) {
            case INT:
                System.out.println(reference.getInt((Object[]) keys));
                break;
            case STRING:
                System.out.println(reference.getString((Object[]) keys));
                break;
            case LIST:
                System.out.println(convertListToString(convertValueListToList(reference.getList((Object[]) keys))));
                break;
        }
    }

    private static void readValue(SupportedType type, String key) {
        switch (type) {
            case INT:
                System.out.println(reference.getInt(key));
                break;
            case STRING:
                System.out.println(reference.getString(key));
                break;
            case LIST:
                System.out.println(convertListToString(convertValueListToList(reference.getList(key))));
                break;
        }
    }

    private static List<String> convertValueListToList(ValueList valueList) {
        List<String> list = new ArrayList<>();

        int size = valueList.length();
        while (--size > -1) {
            list.add(valueList.getNextString());
        }

        return list;
    }

    private static String convertListToString(List<String> list) {
        return list.stream().collect(Collectors.joining(", "));
    }

    private enum SupportedType {
        INT, STRING, LIST;
    }

}
