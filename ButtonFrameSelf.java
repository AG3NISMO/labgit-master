import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonFrameSelf extends JFrame
    implements ActionListener, WindowListener
{
    // Count to track the number of button presses
    private int count = 0;

    // Constructor to set up the buttons and listeners
    public ButtonFrameSelf()
    {
        JButton open = new JButton("Open");
        JButton close = new JButton("Close");

        // The current object (this) is both the action and window listener
        open.addActionListener(this);
        close.addActionListener(this);

        // Set up the layout and add buttons to the pane
        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(open);
        pane.add(close);

        // Add the window listener to handle window events
        addWindowListener(this);
        
        // Window properties
        setSize(300, 150);  // Larger window size for better visibility
        setLocationRelativeTo(null);  // Center the window on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit on close
        setVisible(true);    // Make the window visible
    }

    // Main method to run the application
    public static void main(String args[])
    {
        new ButtonFrameSelf(); // Instantiating ButtonFrameSelf
    }

    // Method from ActionListener interface to handle button presses
    public void actionPerformed(ActionEvent e)
    {
        // Print the number of times a button was pressed and its label 
        System.out.println("Button pressed (" + count++ + ") " + e.getActionCommand());
    }

    // Method from WindowListener interface to handle window closing event
    public void windowClosing(WindowEvent we)
    {
        // Print message and exit application
        System.out.println("Application exiting");
        System.exit(0);
    }

    // Other required methods from WindowListener interface with empty implementations
    public void windowOpened(WindowEvent we) {}
    public void windowIconified(WindowEvent we)  {}
    public void windowDeiconified(WindowEvent we)  {}
    public void windowClosed(WindowEvent we)  {}
    public void windowActivated(WindowEvent we) {}
    public void windowDeactivated(WindowEvent we) {}
}
