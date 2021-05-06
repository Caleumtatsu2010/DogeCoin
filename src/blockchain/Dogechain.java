import java.util.ArrayList;

public class Dogechain 
{
    static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static Boolean isChainValid()
    {
        for(int i=0;i<blockchain.size();i++)
        {
            for(int j=i+1;j<blockchain.size();j++)
            {
                if(!blockchain.get(i).hash.equals(blockchain.get(j).hash))
                {
                    return false;
                }
                if(!blockchain.get(i).hash.equals(blockchain.get(i).caculateHash()))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        blockchain.add(new Block("first block", "0"));
        blockchain.add(new Block("second block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("third block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("forth block", blockchain.get(blockchain.size()-1).hash));
        for(Block i:blockchain)
        {
            System.out.println(i.toString());
        }
        
    }
}
