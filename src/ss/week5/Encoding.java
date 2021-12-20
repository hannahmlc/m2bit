package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 */
public class Encoding {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";
        String input2 = "Hello Big World";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        System.out.println(Hex.encodeHexString(input2.getBytes()));


        String hex = "4d6f64756c652032";
        byte[] bytes = Hex.decodeHex(hex);
        System.out.println(new String(bytes));
    }
}
