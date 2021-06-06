
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
        return Utis.applySha256(previousHash + Long.toString(timeStamp) + data);
    }
    public String toString()
    {
        return "hash: "+hash+"\npreviousHash: "+previousHash+"\ndata: "+data+"\ntimeStamp: "+timeStamp; 
    }
    public mineBlock(int difficulty)
    {
        String target = new String(new char[difficulty]).replace('\0', 0);//create a string with difficulty 0
        
    }

}
