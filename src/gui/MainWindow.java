package gui;

import gui.hackmiiSolutions.HackMiiSolutionsWindow;
import gui.usbLoader.USBLoaderWindow;
import gui.wizard.WizardWindow;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * The main window of ModMiiGui. Displays all options, loads resource bundles i.e. translations
 * @author Joakim Reinert
 *
 */
public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 2740437090361841747L;
	public static ResourceBundle menuItems;
	public static ResourceBundle textAreas;
	public static ResourceBundle basicButtons;
	public static ResourceBundle messages;
	public static ResourceBundle summary;
	public static ResourceBundle tooltips;
	public static ResourceBundle labels;
	
	/**
	 * Initialize and draw the MainWindow
	 */
	public MainWindow() {
		super("ModMiiGui");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		menuItems = ResourceBundle.getBundle("resources.lang.MenuItems");
		textAreas = ResourceBundle.getBundle("resources.lang.TextAreas");
		basicButtons = ResourceBundle.getBundle("resources.lang.BasicButtons");
		messages = ResourceBundle.getBundle("resources.lang.Messages");
		summary = ResourceBundle.getBundle("resources.lang.Summary");
		tooltips = ResourceBundle.getBundle("resources.lang.Tooltips");
		labels = ResourceBundle.getBundle("resources.lang.labels");
		for(JButton button : getMenuButtons())
			panel.add(button);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	/**
	 * Creates the main menu buttons
	 * @return the buttons
	 */
	public JButton[] getMenuButtons() {
		final JButton wizard = new JButton(menuItems.getString("wizard"));
		final JButton usb = new JButton(menuItems.getString("usb"));
		final JButton hack = new JButton(menuItems.getString("hack"));
		JButton sysCheck = new JButton(menuItems.getString("sysCheck"));
		final JButton regChange = new JButton(menuItems.getString("regChange"));
		final JButton sneek = new JButton(menuItems.getString("sneek"));
		final JButton downloads = new JButton(menuItems.getString("downloads"));
		final JButton conf = new JButton(menuItems.getString("conf"));
		final JButton fileCleanup = new JButton(menuItems.getString("fileCleanup"));
		JButton[] buttons = new JButton[] {wizard, usb, hack, sysCheck, regChange, sneek, downloads, conf, fileCleanup};
		ActionListener menuListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton)e.getSource();
				if(source.equals(wizard))
					openWizard();
				if(source.equals(usb))
					openUSB();
				if(source.equals(hack))
					openHack();
				if(source.equals(regChange))
					openRegChange();
				if(source.equals(sneek))
					openSneek();
				if(source.equals(downloads))
					openDownloads();
				if(source.equals(conf))
					openConf();
				if(source.equals(fileCleanup))
					openFileCleanup();
			}
		};
		int maxWidth = 0;
		for(JButton current : buttons) {
			if(current.getPreferredSize().width > maxWidth)
				maxWidth = current.getPreferredSize().width;
			current.addActionListener(menuListener);
		}
		for(JButton current : buttons)
			current.setMaximumSize(new Dimension(maxWidth, current.getPreferredSize().height));
		return buttons;
	}
	/**
	 * Open up the wizard window
	 */
	protected void openWizard() {
		new WizardWindow();
	}
	/**
	 * Open up the USB-Loader wizard
	 */
	protected void openUSB() {
		new USBLoaderWindow();
		
	}
	/**
	 * Open up HackMii solutions
	 */
	protected void openHack() {
		new HackMiiSolutionsWindow();
	}
	protected void openRegChange() {
		
		
	}
	protected void openSneek() {
		// TODO Auto-generated method stub
		
	}
	protected void openDownloads() {
		// TODO Auto-generated method stub
		
	}
	protected void openConf() {
		// TODO Auto-generated method stub
		
	}
	protected void openFileCleanup() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new MainWindow();
	}
}
