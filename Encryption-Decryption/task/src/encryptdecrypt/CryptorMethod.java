package encryptdecrypt;

import java.util.stream.Collectors;

public interface CryptorMethod {
    String crypt(String message, int key);

    default String crypt(String message, int key, char first, char last, int size) {
        return message.chars()
                .map(ch -> ch >= first && ch <= last
                        ? (char) ((ch - first + (key >= 0 ? key : size + key)) % size + first)
                        : (char) ch)
                .mapToObj(Character::toChars).map(String::new).collect(Collectors.joining());
    }
}
