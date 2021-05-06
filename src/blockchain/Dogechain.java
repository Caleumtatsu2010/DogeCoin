import java.util.ArrayList;

public class Dogechain 
{
    static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static void main(String[] args) {
        blockchain.add(new Block("first block", "0"));
        blockchain.add(new Block("second block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("third block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("forth block", blockchain.get(blockchain.size()-1).hash));
        System.out.println(blockchain);
    }
}
