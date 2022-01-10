package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 */
public class Encoding {
    public static void main(String[] args) throws DecoderException {

// -- 5.7 -----------------------------------------------
        String input = "Hello World";
        String input2 = "Hello Big World";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        System.out.println(Hex.encodeHexString(input2.getBytes()));

// -- 5.8 -----------------------------------------------

        String hex = "4d6f64756c652032";
        byte[] bytes = Hex.decodeHex(hex);
        System.out.println(new String(bytes));

// -- 5.9 -----------------------------------------------

        //• encode the string "Hello World" in Base64.
        System.out.println(Base64.encodeBase64String(input.getBytes()));


        //• decode hex string 010203040506 to a byte array
        String hex2 = "010203040506";
        byte[] byteArray = Hex.decodeHex(hex2);
        //encode this byte array with Base64, and print it.
        System.out.println(Base64.encodeBase64String(byteArray));


        //• decode the Base64 string U29mdHdhcmUgRGV2ZWxvcG1lbnQ= and print it.
        System.out.println(new String(Base64.decodeBase64("U29mdHdhcmUgRGV2ZWxvcG1lbnQ=")));


        //• produce the Base64 encoding for each of the following strings: "a", "aa", "aaa"..., "aaaaaaaaaa". Print each result on a new line.
        String a = "a";
        for(int i = 1; i < 10; i++) {
            System.out.println(Base64.encodeBase64String(a.getBytes()));
            a += "a";
        }
    }
}
