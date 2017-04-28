import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by derek on 4/24/17.
 */
public class NodeAnalysis {
    //Properties
    private static int Multiplier(){
        return Ingress.lineSizeMultiplier;
    }

    public static ArrayList<PortalNode> CreateRandomSet(int amountOfNodesToCreate,  int dimensions, Ingress ingress){
        //Create our linked list
        ArrayList<PortalNode> nodes = new ArrayList<>();

        //Go through a loop and create random nodes
        for(int i = 0;i < amountOfNodesToCreate;i++){
            //Create our node
            PortalNode node = new PortalNode(NodeAnalysis.CreateRandomPoint(), ingress);
//            System.out.println("Node Created");

            //If the node already exists, go down an increment
            if(nodes.contains(node)){
//               System.out.println("Node Exists");
                i--;
            }else {
                //Add the node to the list
                nodes.add(node);
            }
        }

        Ingress.PrintLn(nodes.size() + " Portal Node(s) have been created");
        //Return our ArrayList of nodes
        return nodes;
    }

    private static Point CreateRandomPoint(){
        Random random = new Random();

        return new Point(random.nextInt(100) * Multiplier(), random.nextInt(100) * Multiplier());
    }
}
