import java.security.MessageDigest;
 
public class MD5Hashing 
{
    public static void main(String[] args)throws Exception
    {
    	String password = "123456";
 
        MessageDigest md = MessageDigest.getInstance("MD5"); // Create a message digest object
        md.update(password.getBytes()); // Encoding the password byte by byte
 
        byte byteData[] = md.digest(); // create a byte array
 
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