import java.awt.event.*
import java.awt.*
import javax.swing.*

class ColorChooserExample// Konstruktor
internal constructor() : JFrame(), ActionListener {

    // create a button
    internal var b = JButton("color")

    internal var c = contentPane

    init {

        // set Layout
        c.layout = FlowLayout()

        // add Listener
        b.addActionListener(this)

        // add button to the Container
        c.add(b)
    }

    override fun actionPerformed(e: ActionEvent) {

        val initialcolor = Color.RED

        // color chooser Dialog Box
        val color = JColorChooser.showDialog(this,
                "Select a color", initialcolor)

        // set Background color of the Conatiner
        c.background = color
    }

    companion object {

        // Main Method
        @JvmStatic
        fun main(args: Array<String>) {

            val ch = ColorChooserExample()
            ch.setSize(400, 400)
            ch.isVisible = true
            ch.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        }
    }
}