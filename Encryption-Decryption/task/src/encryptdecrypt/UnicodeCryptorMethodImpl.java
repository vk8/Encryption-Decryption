package encryptdecrypt;

public class UnicodeCryptorMethodImpl implements CryptorMethod {
    final char FIST_SYMBOL = ' ';
    final char LAST_SYMBOL = '~';
    final int ALPHABET_SIZE = LAST_SYMBOL - FIST_SYMBOL + 1;

    @Override
    public String crypt(String message, int key) {
        return crypt(message, key % ALPHABET_SIZE, FIST_SYMBOL, LAST_SYMBOL, ALPHABET_SIZE);
    }
}
