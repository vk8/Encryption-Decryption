package encryptdecrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<String> arg = Arrays.asList(args);
        int index;
        var mode = ((index = arg.indexOf("-mode")) >= 0) ? args[index + 1] : "enc";
        var key = ((index = arg.indexOf("-key")) >= 0) ? Integer.parseInt(args[index + 1]) : 0;
        var data = ((index = arg.indexOf("-data")) >= 0) ? args[index + 1] : "";
        var in = ((index = arg.indexOf("-in")) >= 0) ? args[index + 1] : "";
        var out = ((index = arg.indexOf("-out")) >= 0) ? args[index + 1] : "";
        var alg = ((index = arg.indexOf("-alg")) >= 0) ? args[index + 1] : "shift";
        switch (mode) {
            case "dec":
                key = -key;
                break;
        }
        if (data.equals("") && !in.equals("")) {
            try {
                data = new String(Files.readAllBytes(Paths.get(in)));
            } catch (IOException e) {
                System.out.printf("Cannot read file: %s", e.getMessage());
            }
        }
        MessageCryptor messageCryptor = new MessageCryptor();
        switch (alg) {
            case "unicode":
                messageCryptor.setMethod(new UnicodeCryptorMethodImpl());
                break;
            case "shift":
            default:
                messageCryptor.setMethod(new ShiftCryptorMethodImpl());
        }
        var output = messageCryptor.crypt(data, key);
        if (out.equals("")) {
            System.out.println(output);
        } else {
            try (FileWriter writer = new FileWriter(out)) {
                writer.write(output);
            } catch (IOException e) {
                System.out.printf("An exception occurred %s", e.getMessage());
            }
        }
    }
}