import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;


public class Utis 
{
    //caculate hash algorithm
    public static String applySha256(String input)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");//get SHA-256 algorithm
            // convert input to hashcode using SHA-256
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for(int i=0;i<hash.length;i++)
            {
                String hex = Integer.toHexString(0xff & hash[i]);//convert each byte which is hashed to string
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
    public static String getStringFromKey(Key key)
    {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
    //generate signature of transaction
    public static byte[] applyECDSASig(PrivateKey privatekey, String input)
    {
        Signature dsa;//signature object
        byte output[] = new byte[0];//real signature in byte type
        try {
            dsa = Signature.getInstance("ECDSA", "BC");//get ECDSA signature algorithm attach to dsa
            dsa.initSign(privatekey);//init signature object dsa
            byte strByte[] = input.getBytes();
            dsa.update(strByte);//update input's byte to dsa signature objects

            byte []realSig = dsa.sign();//get real signature from dsa
            output = realSig;
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
        return output;
    }
    //verifies a  signature
    public static boolean verifyECDSASig(PublicKey publickey, String data, byte[] signature) throws NoSuchAlgorithmException, NoSuchProviderException
    {
        try {
            Signature ecdsaVerify = Signature.getInstance("ECDSA", "BC");
            ecdsaVerify.initVerify(publickey);
            ecdsaVerify.update(data.getBytes());
            return ecdsaVerify.verify(signature);   
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
}
