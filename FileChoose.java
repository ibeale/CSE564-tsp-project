import javax.swing.*;
import javax.swing.filechooser.*;

public class FileChoose extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static JLabel l = new JLabel("no file selected");
    public String fileNamenv;

    public FileChoose() {
    	JFileChooser j = new JFileChooser(".");
        j.setAcceptAllFileFilterUsed(false); 
        j.setDialogTitle("Select a .tsp file"); 
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .tsp/.txt files", "tsp", "txt"); 
        j.addChoosableFileFilter(restrict); 
        int r = j.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            fileNamenv = j.getSelectedFile().getAbsolutePath();
            l.setText(j.getSelectedFile().getPath());
        } else {
            l.setText("the user cancelled the operation");
        }
    }

}
