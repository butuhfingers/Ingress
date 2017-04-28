import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by derek on 4/24/17.
 */
public class Ingress {
    //Variables
    private int ingressNodeCount = 100;    //The amount of nodes we are creating
    private int screenSize = 1200;   //The size of the GUI screen
    public static int lineSizeMultiplier = 12; //This controls the size of the lines incase we have a lot of them

    private ArrayList<PortalNode> nodes = new ArrayList<>();
    private ArrayList<Link> links = new ArrayList<>();
    private ArrayList<Field> fields = new ArrayList<>();

    private IngressGraphic ingressGraphics;

    //Properties
    public static boolean DebugMode(){
        return false;
    }

    public ArrayList<PortalNode> Nodes(){
        return nodes;
    }

    public ArrayList<Link> Links(){
        return links;
    }
    public void addLink(Link linkToAdd){
        if(!links.contains(linkToAdd)){
            links.add(linkToAdd);
        }
    }

    //Constructor
    public Ingress(){

    }

    //The main method to run
    public static void main(String[] args){
        //Create Ingress
        Ingress ingress = new Ingress();
        //Create the random nodes to use
        ingress.nodes = NodeAnalysis.CreateRandomSet(ingress.ingressNodeCount, 100, ingress);

        LinkAnalysis.CreateLinksBetweenNodes(ingress.nodes);
    //    LinkAnalysis.RemoveLinkIntersections(ingress.Links());


//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
                IngressGraphic ingressGraphic = new IngressGraphic(ingress);
                ingressGraphic.setSize(ingress.screenSize, ingress.screenSize);
                ingressGraphic.setVisible(true);
//            }
//        });
    }

    public static void PrintLn(String stringToPrint){
        //Check if debug mode is active before we print
        if(Ingress.DebugMode())
            System.out.println(stringToPrint);
    }
}
