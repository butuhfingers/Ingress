import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by derek on 4/24/17.
 */
public class PortalNode {
    //Variables
    private Point location;
    private ArrayList<Link> links = new ArrayList<>();
    private Ingress ingressModel;

    //Properties
    public Point Location(){
        return location;
    }

    public ArrayList<Link> Links(){
        return links;
    }
    public Ingress IngressModel(){
        return ingressModel;
    }

    public PortalNode(Point location, Ingress ingress){
        this.location = location;
        this.ingressModel = ingress;
    }

    //Create a link between this node and the destination node
    public void CreateLink(PortalNode destinationNode){
        Link link = new Link(this, destinationNode);

        if(!links.contains(link)){
            links.add(link);
            ingressModel.addLink(link);
        }
    }

    @Override
    public String toString(){
        return "(" + this.location.x + " , " + this.location.y + ")";
    }

    //Check if we are equal
    @Override
    public boolean equals(Object nodeToCheck){
        //Check that it is an instance of PortalNode
        if(nodeToCheck instanceof PortalNode) {
            PortalNode node = (PortalNode) nodeToCheck;
            //Check if the points are the same
            if (this.Location().equals(node.Location())) {
                return true;
            }
        }

        return false;
    }
}
