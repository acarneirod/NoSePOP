import javax.swing.*;
import java.awt.*;

public class ERROR{
    private JPanel mainPanel;

    public ERROR(String text){
        JFrame f = new JFrame();
        f.setTitle("ERROR");
        f.setSize(300, 150);
        f.add(new Label(text));
        f.setVisible(true);

    }
}
