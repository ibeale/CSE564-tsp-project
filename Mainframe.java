import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Mainframe extends JFrame implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 750;
    private static final int FRAME_HEIGHT = 800;
    JMenu menu, project, about;  
    JMenuItem i1, i2, i3, i4, i5;  
	public Mainframe(){
		Controller actionController = new ActionController();
		Controller mouseController = new MouseController();
		this.setTitle("BTX");
		
		
		JMenuBar mb=new JMenuBar();  
        menu=new JMenu("File");  
        project=new JMenu("Project");  
        about=new JMenu("About");  
        i1=new JMenuItem("Open");  
        i2=new JMenuItem("Save");  
        i3=new JMenuItem("New");  
        i4=new JMenuItem("Run");  
        i5=new JMenuItem("Stop");  
        menu.add(i1); menu.add(i2); 
        project.add(i3); project.add(i4); project.add(i5);  
        i1.addActionListener((ActionListener) actionController);
        i2.addActionListener((ActionListener) actionController);
        i3.addActionListener((ActionListener) actionController);
        i4.addActionListener((ActionListener) actionController);
        i5.addActionListener((ActionListener) actionController);
        mb.add(menu);  
        mb.add(project);  
        mb.add(about);  
        setJMenuBar(mb);  
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLayout(new BorderLayout());
		Canvas ui = new Canvas();
        ui.addMouseListener((MouseListener) mouseController);
		this.add(ui, BorderLayout.CENTER);
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}
