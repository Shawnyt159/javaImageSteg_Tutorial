import java.io.File;

import javax.swing.JFileChooser;

public class FileChooser {
	public static File MakeFileChooser() {
		JFileChooser fileChooser = new JFileChooser();
		
        int option = fileChooser.showOpenDialog(null);
        if(option == JFileChooser.APPROVE_OPTION){
        	File file = fileChooser.getSelectedFile();
        	return file;
        }
        return null;
	}
}
