/**
 * Created by derek on 4/24/17.
 */
public class Field {
    //Variables
    private Link[] fieldEdges;

    public Field(Link[] fieldLinks) throws Exception{
        //Check if we have only 3 links cooming in
        if(fieldLinks.length != 3){
            throw new Exception("You can only have 3 links for a field");
        }

        //Set our variables
        fieldEdges = new Link[3];
        fieldEdges[0] = fieldLinks[0];
        fieldEdges[1] = fieldLinks[1];
        fieldEdges[2] = fieldLinks[2];
    }
}
