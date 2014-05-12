package Engine;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Foundation {
    public static Image loadSprite(String URL) {
        ImageIcon newIcon = new ImageIcon(URL);
        
	return newIcon.getImage(); 
    }
}
