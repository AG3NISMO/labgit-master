import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonFrameInner extends JFrame
{
    // Constructor: Sets up the JFrame with two buttons (Open and Close)
    public ButtonFrameInner()
    {
        // Create buttons
        JButton open = new JButton("Open");
        JButton close = new JButton("Close");
        
        // Create an instance of the ActionListener 
        ActionListener listener = new ButtonListener();

        // Add ActionListeners to the buttons
        open.addActionListener(listener);
        close.addActionListener(listener);

        // Set up the container and layout
        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(open);
        pane.add(close);

        // Add window closing event listener 
        addWindowListener(new ButtonCloser());

        // Set window properties
        setSize(300, 150);  // Larger window for better visibility
        setLocationRelativeTo(null);  // Center the window on the screen
        setVisible(true);  // Make the window visible
    }

    // Main method to run the application
    public static void main(String args[])
    {
        new ButtonFrameInner(); // Instantiating the updated inner-class based ButtonFrame
    }

    // Inner class to handle button events 
    private class ButtonListener implements ActionListener
    {
        int count = 0; // Counter to track button presses
        public void actionPerformed(ActionEvent e)
        {
            // Print button press count and the button's action command 
            System.out.println("Button pressed (" + count++ + ") " + e.getActionCommand());
        }
    }

    // Inner class to handle window closing event 
    private class ButtonCloser extends WindowAdapter
    {
        public void windowClosing(WindowEvent we)
        {
            // Print exit message and close the application
            System.out.println("Application exiting");
            System.exit(0);
        }
    }
}
