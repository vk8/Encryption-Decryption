package encryptdecrypt;

public class MessageCryptor {

    private CryptorMethod method;

    public void setMethod(CryptorMethod method) {
        this.method = method;
    }

    public String crypt(String message, int key) {
        return method.crypt(message, key);
    }
}
