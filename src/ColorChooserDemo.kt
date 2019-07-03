import java.awt.*
import java.awt.event.*
import javax.swing.*
import javax.swing.event.*
import javax.swing.colorchooser.*

class ColorChooserDemo : JPanel(BorderLayout()), ChangeListener {

    protected var Jcc: JColorChooser
    protected var label: JLabel

    init {

        // Set up the Label at the top of the window
        label = JLabel("Welcome to GeeksforGeeks",
                JLabel.CENTER)

        // set the foreground color of the text
        label.foreground = Color.green

        // set background color of the field
        label.background = Color.WHITE
        label.isOpaque = true

        // set font type and size of the text
        label.font = Font("SansSerif", Font.BOLD, 30)

        // set size of the label
        label.preferredSize = Dimension(100, 65)

        // create a Panel and set its layout
        val bannerPanel = JPanel(BorderLayout())
        bannerPanel.add(label, BorderLayout.CENTER)
        bannerPanel.border = BorderFactory.createTitledBorder("Label")

        // Set up color chooser for setting text color
        Jcc = JColorChooser(label.foreground)
        Jcc.selectionModel.addChangeListener(this)
        Jcc.border = BorderFactory.createTitledBorder(
                "Choose Text Color")

        add(bannerPanel, BorderLayout.CENTER)
        add(Jcc, BorderLayout.PAGE_END)
    }

    override fun stateChanged(e: ChangeEvent) {
        val newColor = Jcc.color
        label.foreground = newColor
    }

    companion object {

        // Create the GUI and show it.  For thread safety,
        // this method should be invoked from the
        // event-dispatching thread.
        private fun createAndShowGUI() {

            // Create and set up the window.
            val frame = JFrame("ColorChooserDemo")

            // set default close operation of the window.
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

            // Create and set up the content pane.
            val newContentPane = ColorChooserDemo()

            // content panes must be opaque
            newContentPane.isOpaque = true

            // add content pane to the frame
            frame.contentPane = newContentPane

            // Display the window.
            frame.pack()
            frame.isVisible = true
        }

        // Main Method
        @JvmStatic
        fun main(args: Array<String>) {

            // Schedule a job for the event-dispatching thread:
            // creating and showing this application's GUI.
            javax.swing.SwingUtilities.invokeLater { createAndShowGUI() }
        }
    }
}
