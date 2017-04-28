import java.util.ArrayList;

/**
 * Created by derek on 4/24/17.
 */
public class LinkAnalysis {

    //Create the links between nodes
    public static void CreateLinksBetweenNodes(ArrayList<PortalNode> nodesToCreateLinksFrom){
        int linkCounter = 0;

        //Go through all the nodes and create links between all other nodes
        for(int originNodeInc = 0;originNodeInc < nodesToCreateLinksFrom.size();originNodeInc++){
            //Set our origin  node
            PortalNode originNode = nodesToCreateLinksFrom.get(originNodeInc);

            //These are the nodes we are connecting to
            for(int destinationNodeInc = 0;destinationNodeInc < nodesToCreateLinksFrom.size();destinationNodeInc++){
                //Set our destination node
                boolean canConnect = true;
                PortalNode destinationNode = nodesToCreateLinksFrom.get(destinationNodeInc);

                //Check if they are equal, if so move on to the next part of the loop
                if(originNode.equals(destinationNode)){
                    continue;
                }
                //Check if the intersection is possible
                for(int link = 0;link < originNode.IngressModel().Links().size();link++) {
                    if(!IntersectionPossible(new Link(originNode, destinationNode), originNode.IngressModel().Links().get(link))) {
                        canConnect = false;
                        break;
                    }
                }

                if(canConnect)
                    originNode.CreateLink(destinationNode);

                linkCounter++;
            }
        }

        Ingress.PrintLn(linkCounter + " links created!");
    }

    //Check the links for any intersections and remove them
    public static void RemoveLinkIntersections(ArrayList<Link> linksToCheck){
        //Go through all links and remove intersections
        for(int intersectingLink = linksToCheck.size() - 1;intersectingLink > -1;intersectingLink--){
            //Check if we are null
            if(linksToCheck.get(intersectingLink) == null){
                continue;
            }

            //Go through all elements in the link list
            for(int link = 0;link < linksToCheck.size();link++) {
                Link link1 = linksToCheck.get(intersectingLink);
                Link link2 = linksToCheck.get(link);
                //check if we are intersecting
                if(!IntersectionPossible(link1, link2)) {
                    linksToCheck.remove(intersectingLink);
                    Ingress.PrintLn(intersectingLink + "Removing intersection");
                    break;
                }
            }
        }
    }

    public static boolean IntersectionPossible(Link link1, Link link2){
        //We first need to check if the points match
        if (!link1.Origin().equals(link2.Origin()) && !link1.Destination().equals(link2.Destination()) &&
                !link1.Origin().equals(link2.Destination()) && !link1.Destination().equals(link2.Origin())){

            if (!link1.equals(link2) &&
                    link1.PortalLine().intersectsLine(link2.PortalLine())) {

                return false;
            }
        }

        return true;
    }
}
