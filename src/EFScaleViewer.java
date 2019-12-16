
import javax.swing.JFrame;

public class EFScaleViewer {

	public static void main(String[] args) {
		//Ian Tibe

		//constants
		final int FRAMEWIDTH = 350;
		final int FRAMEHEIGHT = 250;
		final String FRAMETITLE = "EF Calculator by Ian Tibe";

		// create frame 
		JFrame frame = new EFScaleFrame();
		
		
		// set frame parameters and make visible
		frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		frame.setTitle(FRAMETITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
