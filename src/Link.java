import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

/**
 * Created by derek on 4/24/17.
 */
public class Link {
    private PortalNode origin; //Our starting point
    private PortalNode destination;    //The point we want to go to

    //Properties
    public PortalNode Origin(){
        return origin;
    }

    public PortalNode Destination(){
        return destination;
    }

    public Line2D PortalLine(){
        Line2D line = new Line2D.Double(origin.Location().x, origin.Location().y,
                                    destination.Location().x, destination.Location().y);

        return line;
    }

    //Constructor
    public Link(PortalNode origin, PortalNode destination){
        //Check for a null origin
//        if(origin == null) {
//            throw new Exception("Can not have a null origin");
//        }
//        //Check if we have a null destination
//        if(destination == null){
//            throw new Exception("Can not have a null destination");
//        }

        //Set our origin and destination
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public String toString(){
        return "(" + Destination().toString() + " , " + origin.toString() + "";
    }

    @Override
    public boolean equals(Object linkToCheck){
        //Check that it is an instance of PortalNode
        if(linkToCheck instanceof Link) {
            Link link = (Link) linkToCheck;
            //Check if the points are the same
            if (this.origin.equals(link.origin) &&
                    this.destination.equals(link.destination)) {
                return true;
            }
        }

        return false;
    }
}
