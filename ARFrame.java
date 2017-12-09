package arAristotleRegimeClasses;

import java.awt.Graphics2D;

import javax.swing.JFrame;

public class ARFrame extends JFrame {

	//public static void main(String[] args) {

	//}
	
	Graphics2D gui = (Graphics2D) this.getGraphics(); 
	//gui.setBackground
	
	


/*
This is Swing- Can change 'look and feel' - change frame and all components together
Allows you to get necessary stuff, like window
Graphics2D g = (Graphics2D) this.getGraphics();
	A canvas you can draw on
	 g.setColor(Color.white); - sticky command
	 Next command - clears screen, draws new thing
	 Put sting - g.drawString( give coordinates )
	 g.fillRect
	 g.drawRect
	 g.drawLine
	 With memoization, count huge numbers quickly
Draw on a Jpanel 
	 Put them on the canvas
	 Component used to hold other things or to be drawn on
	 Put size of panel (2,2) - always same size regions
	 Put things on panel - add(new Jlabel("Height))
		 No control on where these things go --- one per region
		 Not name if not want to change
	 newJTextField --- name is so that can read & write to
	 This.add(panelname) to add to Graphics2D
Buttons
	 New Jbutton - name
	 New Jcheckbox
	 Can add panels atop panels
JSLider
	 Built a time panel, then set layout, then 
	 setMajorTickSpacing, setMinorTickSpacing; set
Also Button.backgroundcolor = blue (to change)
Tc.pack; (figure out where components go)
TC.setVisible(true); show on screen
How to talk to components

How to make the button do something------
Button.addActionListener

An action listener (also for mouse) is an object that implements the action listener interface
	Could do in another class
	Put all necessary methods for the interface at the bottom if simple project
	
	Key
	actionPerformed( ActionEvent e) //must write if putting ActionListener
	If(t.getSoucr() == tt) // if it's this button, do this and this

Attach listeners to the text book - as I change, it started new windows immediately without clicking new button
	Add ChangeListener.
	t.height.changeListener(this
	Another method that handles what happens if changed, like actionPerformed
	
Slider
	As slide, real-time implement change
	Add implement change listener
		stateChanged (ChangeEvent evt)
			Set new time (ex.) - override it
			
Clicking 
	Mousehandlers as in racket -------- coordinate
	
Origin is the edge of the frame --- add 20 pixels to get below the frame to close out the frame


Panel.setLayout(new BorderLayout) --- must instantiate BorderLayout
5 regions - North, South, East, West, Center
Panel.add(tiling button, BorderLayout.NORTH) --- button added to north
These regions resize according to what you put on it [otherwise center takes up the entire space]
*/
}