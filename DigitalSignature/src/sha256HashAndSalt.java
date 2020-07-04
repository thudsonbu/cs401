import java.security.MessageDigest;
import java.security.SecureRandom;

public class sha256HashAndSalt
{
    public static void main(String[] args)throws Exception
    {
    	String password = "&^dk37Te5(ehr";
 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); // Create a message digest object

        SecureRandom random = new SecureRandom(); // Create a secure random object

        byte[] salt = new byte[16]; // Create a new blank salt to be added

        random.nextBytes(salt); // Java random class creates random information for salt and adds to salt byte array

        md.update(salt); // random information is added to the message digests internal array

        md.update(password.getBytes()); // users password is added to message digests internal array
 
        byte[] byteData = md.digest(); // message digest uses SHA-256 to compute hashed password
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer(); // a string buffer is a modifiable string class
        for (int i = 0; i < byteData.length; i++) { // for each byte we convert to string
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        // hexidicimal notation uses 16 char to represent numbers instead of ten
        // uses 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F
        // a hex digit needs 4 bits to hold its value it saves space and is based on 16 rather then ten
        // numbers up to 16 can be represented with a single character
 
        System.out.println("Digest(in hex format):: " + sb.toString());
 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	System.out.println("Digest(in hex format):: " + hexString.toString());
    }
}