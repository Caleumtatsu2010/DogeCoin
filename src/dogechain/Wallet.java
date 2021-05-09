import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;

public class Wallet 
{
    public PublicKey publicKey;
    public PrivateKey privateKey;
    public Wallet()
    {
        generateKeyPair();
    }
    public void generateKeyPair()
    {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            //Innitialize key generator and generate a KeyPair
            keyGen.initialize(ecSpec, random);

            KeyPair keyPair = keyGen.generateKeyPair();
            this.publicKey = keyPair.getPublic();
            this.privateKey = keyPair.getPrivate();
        } catch (Exception e) 
        {
            throw new RuntimeException();
            
        }
    }
}
