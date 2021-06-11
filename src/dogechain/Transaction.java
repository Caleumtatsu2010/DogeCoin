import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class Transaction 
{
    public String transactionId;//id of transaction
    public PublicKey sender;//from wallet publicKey (previous wallet)
    public PublicKey reciepent;//to wallet publickey (next wallet)
    public float value;//the amount of coin

    public byte[]signature;//  signature of transaction

    //transactions link to each other
    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();//reference to previous transaction
    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();//amount of relevant trans will be recieved from this trans

    private static int consequence = 0;//counter use to avoid same hash in 2 transaction

    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs)
    {
        this.sender = from;
        this.reciepent = to;
        this.value = value;
        this.inputs = inputs;
    }
    //caclulate hash value of an transaction
    private String caculateHash()
    {
        consequence++;
        Utis.applySha256(Utis.getStringFromKey(sender) + Utis.getStringFromKey(reciepent) + Float.toString(value) + consequence);
        
    }
    //generate signature from 
    public void generateSignature(PrivateKey key)
    {
        String data = Utis.getStringFromKey(sender) + Utis.getStringFromKey(reciepent) + Float.toString(value);
        signature = Utis.applyECDSASig(key, data)//generate signature form sender , recieoent wallet and the amount of coins
    }
    public boolean verifySignature()
    {
        return (Utis)
    }



}
