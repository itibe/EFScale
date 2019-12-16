import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EFScaleFrame extends JFrame {
	// Ian Tibe

	// Data fields and constants
	private Graphic drawing;
	private EFScale calc;
	private JPanel panel;
	private JLabel instructionLabel;
	private JPanel mainPanel;
	private JTextField input;
	private JButton submit;
	private ButtonListener instance;
	private JLabel resultsLabel;
	private final int TEXTBOXWIDTH = 6;
	private final String SUBMITBUTTONTEXT = "Submit";
	private final String LABELINSTRUCTION = "Please enter a Wind Speed: ";
	private final String RESULTSLABEL = "The EF Rating is: ";
	private final int CHARTWIDTH = 225;
	private final int CHARTHEIGHT = 225;

	// Constructors
	EFScaleFrame() {
		instructionLabel = new JLabel(LABELINSTRUCTION);
		drawing = new Graphic();
		panel = new JPanel();
		input = new JTextField(TEXTBOXWIDTH);
		submit = new JButton(SUBMITBUTTONTEXT);
		calc = new EFScale();
		instance = new ButtonListener();
		resultsLabel = new JLabel("");
		mainPanel = new JPanel();

		mainPanel.setLayout(new BorderLayout());

		panel.add(instructionLabel);
		panel.add(input);
		panel.add(submit);

		mainPanel.add(resultsLabel, BorderLayout.NORTH);
		drawing.setPreferredSize(new Dimension(CHARTWIDTH, CHARTHEIGHT));
		mainPanel.add(drawing, BorderLayout.CENTER);
		mainPanel.add(panel, BorderLayout.SOUTH);

		add(mainPanel);
		submit.addActionListener(instance);
	}

	// event listener class

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				String response = input.getText();
				int entry = Integer.parseInt(response);
				// submit entry to object that will calculate EF Level
				calc.setWindSpeed(entry);
				// Set drawing to resulting EF Level
				drawing.generateCoordinates(calc.getEFScale());
				// Display resulting EF Level
				resultsLabel.setText(RESULTSLABEL + calc.getEFScale());

			} catch (NumberFormatException exception) {
				resultsLabel.setText("Please enter an Integer");
				// this will reset the graphic to zero during a error condition
				drawing.generateCoordinates(0);

			} catch (IllegalArgumentException exception2) {
				resultsLabel.setText("Please enter a number above " + calc.getWINDSPEED_RANGE_6_LOW());
				// this will reset the graphic to zero during a error condition
				drawing.generateCoordinates(0);
			}

		}

	}

}
