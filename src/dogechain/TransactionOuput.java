public class TransactionOutput
{
    public String id //id of transaction
    public PublicKey reciepent // wallet's key will be recieve these coins (new owner of these coins)
    public float value//the amount of coins 
    public String parentTransactionId//the id of the transaction this transaction send coins to
} 