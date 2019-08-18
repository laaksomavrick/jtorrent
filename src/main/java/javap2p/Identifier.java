package javap2p;

import java.security.MessageDigest;
import java.util.UUID;

class Identifier {

    private static final String GENERATE_ID_ALGORITHM = "SHA-256";
    private static final String STRING_ENCODING = "UTF-8";

    static String generateId() {
        try {
            var uuid = UUID.randomUUID();
            var salt = MessageDigest.getInstance(GENERATE_ID_ALGORITHM);
            salt.update(uuid.toString().getBytes(STRING_ENCODING));
            var digest = salt.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }

//    static Number getDistance(String a, String b) {
//    }


}
