package encryptdecrypt;

public class ShiftCryptorMethodImpl implements CryptorMethod {
    final char FIST_SYMBOL_LC = 'a';
    final char LAST_SYMBOL_LC = 'z';
    final int ALPHABET_SIZE_LC = LAST_SYMBOL_LC - FIST_SYMBOL_LC + 1;
    final char FIST_SYMBOL_UC = 'A';
    final char LAST_SYMBOL_UC = 'Z';
    final int ALPHABET_SIZE_UC = LAST_SYMBOL_UC - FIST_SYMBOL_UC + 1;

    @Override
    public String crypt(String message, int key) {
        return cryptUC(cryptLC(message, key % ALPHABET_SIZE_LC), key % ALPHABET_SIZE_UC);
    }

    private String cryptLC(String message, int key) {
        return crypt(message, key, FIST_SYMBOL_LC, LAST_SYMBOL_LC, ALPHABET_SIZE_LC);
    }

    private String cryptUC(String message, int key) {
        return crypt(message, key, FIST_SYMBOL_UC, LAST_SYMBOL_UC, ALPHABET_SIZE_UC);
    }
}
