import javax.swing.*;
import java.awt.*;

public class INFO {
    private JPanel mainPanel;

    public INFO(String text){
        JFrame f = new JFrame();
        f.setTitle("INFO");
        f.setSize(300, 150);
        f.add(new Label(text));
        f.setVisible(true);

    }
}
