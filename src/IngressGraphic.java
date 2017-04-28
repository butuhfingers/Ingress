import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by derek on 4/24/17.
 */
public class IngressGraphic extends JFrame {

    private Ingress ingressModel;

    public IngressGraphic(Ingress ingressModel) {
        super("Lines Drawing Demo");
        this.ingressModel = ingressModel;

        setSize(480, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int pointSize = 10;

        //Go through and draw all points
        for(int nodes = 0;nodes < ingressModel.Nodes().size();nodes++){
            Point point = ingressModel.Nodes().get(nodes).Location();
            g2d.fillOval(point.x - (pointSize / 2), point.y - (pointSize / 2), pointSize, pointSize);
        }

        //Go through and draw all lines
        for(int n = 0;n < ingressModel.Links().size();n++){
            g2d.draw(ingressModel.Links().get(n).PortalLine());
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
}
