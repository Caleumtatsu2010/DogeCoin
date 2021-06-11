import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;

public class Wallet 
{
    //id of wallet
    public PublicKey publicKey;
    //password of wallet
    public PrivateKey privateKey;
    public Wallet()
    {
        //generate when wallet is created
        generateKeyPair();
    }
    //generate public key vs private key randomly
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
