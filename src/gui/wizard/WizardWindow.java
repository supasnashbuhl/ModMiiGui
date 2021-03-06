package gui.wizard;

import gui.SequencePanel;
import gui.SwitchFrame;
import tools.WizardCollector;

public class WizardWindow extends SwitchFrame {

	private static final long serialVersionUID = -1782485785505290771L;
	public WizardWindow() {
		super("ModMiiGui - ModMii Wizard + Guide", new WizardCollector());
		setPanel(getFirstPanel());
		setCollectorMode("W");
		setVisible(true);
	}
	private SequencePanel getFirstPanel() {
		return new FirstPanel(null, this);
	}
}
