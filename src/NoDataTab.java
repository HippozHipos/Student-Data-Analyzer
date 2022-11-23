import javax.swing.*;
import java.awt.*;

public class NoDataTab extends JPanel {
    public void paintComponent(Graphics gfx){
        super.paintComponent(gfx);
        gfx.drawString("Upload data to start analyzing", 30, 30);
    }
}
