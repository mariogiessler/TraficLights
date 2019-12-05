import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * In dieser Klasse erzeugen Wir uns ein JFrame (Java-Fenster). Das JFrame hat
 * eine Referenz von unserem DrawPanel, auf welchem gezeichnet wird.
 *
 * @author ST-Page.de
 *
 */
public class PaintWindow extends JFrame {

    private static final long serialVersionUID = -5639142697589144988L;
    private DrawPanel panel = new DrawPanel();

    public PaintWindow() {
        this.setTitle("Malen mit Java im einem JPanel");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.add(panel);
    }

    /**
     * Hier starte ich die Klasse. Dazu erstelle ich ein neues Objekt auf dieses
     * Klasse.
     *
     * @param args
     */
    public static void main(String[] args) {
        new PaintWindow();
    }
}

/**
 * Die Klasse DrawPanel hat als Grundlage ein JPanel. Wir können die Funktionen
 * eines JPanels nutzen und für unsere Zwecke erweitern und besser nutzen.
 *
 * Später sollte man besser hier eine eigene Java-Datei draus machen, dies ist
 * so kein guter Stil aber zur Veranschaulichung ist er besser.
 *
 * @author KranzKrone
 *
 */
class DrawPanel extends JPanel {
    private static final long serialVersionUID = -67893636709725974L;

    public DrawPanel() {
        // Zu meinem DrawPanel füge ich einen MouseMotionListener hinzu und
        // frage ab wo die Maus gerade ist.
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent arg0) {
            }

            @Override
            public void mouseDragged(MouseEvent arg0) {
                // Das MouseEvent gibt es schon von der JRE. So dass Wir das
                // MouseEvent-Objekt auslesen können.
                drawPoint(arg0.getX(), arg0.getY());
                // Ausgabe der Mauskoordinaten in der Kommandozeile
                System.out.println(arg0.getX() + " / " + arg0.getY());
            }
        });
    }

    private void drawPoint(int x, int y) {
        // Neues Grafik-Objekt aus dem altem Erzeugen und darauf dann die
        // Grafik-Funktionen nutzen.
        Graphics g = this.getGraphics();
        g.fillOval(x, y, 3, 3);
    }
}
