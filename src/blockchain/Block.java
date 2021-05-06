
import java.util.*;
public class Block 
{
    public String hash;
    public String previousHash;
    public String data;
    public long timeStamp;
    public Block(String data, String previousHash)
    {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.data = data;
        this.hash = caculateHash();
    }
    public String caculateHash()
    {
        //caculate hash
        return Utis.useHash(previousHash + Long.toString(timeStamp) + data);
    }
    public String toString()
    {
        return "hash: "+hash+" previousHash: "+previousHash+" data: "+data+" timeStamp: "+timeStamp; 
    }

}
