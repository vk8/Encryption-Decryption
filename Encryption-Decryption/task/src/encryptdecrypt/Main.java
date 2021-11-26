package encryptdecrypt;

import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {
        System.out.println(encrypt("we found a treasure!"));
    }

    private static String encrypt(String message) {
        return message.toLowerCase().chars()
                .map(ch -> ch >= 'a' && ch <= 'z' ? (char) ('z' - ch + 'a') : (char) ch)
                .mapToObj(Character::toChars)
                .map(String::new)
                .collect(Collectors.joining());
    }
}