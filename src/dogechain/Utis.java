import java.security.MessageDigest;

public class Utis 
{
    public static String useHash(String input)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");//get SHA-256 algorithm
            // convert input to hashcode using SHA-256
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for(int i=0;i<hash.length;i++)
            {
                String hex = Integer.toHexString(0xff & hash[i]);//convert hashcode to string
                if(hex.length() == 1)
                {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        
    }
    
}
