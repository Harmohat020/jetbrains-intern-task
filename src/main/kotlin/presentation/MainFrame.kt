package presentation

import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import javax.swing.*

class MainFrame : JFrame() {
    private val componentWidth = 200
    val loadFileButton = customButton("Load file")
    val textArea = JTextArea().apply {
        isEditable = false
        lineWrap = true
        wrapStyleWord = true
    }

    private val scrollPane = JScrollPane(textArea)

    init {
        layout = BorderLayout()
        add(loadFileButton, BorderLayout.NORTH)
        add(scrollPane, BorderLayout.CENTER)

        extendedState = MAXIMIZED_BOTH
        defaultCloseOperation = EXIT_ON_CLOSE
    }

    private fun customButton(text: String): JButton {
        return JButton(text).apply {
            preferredSize = Dimension(componentWidth, 45)
            isBorderPainted = false
        }
    }

    fun showFileContent(content: String) {
        textArea.text = content
    }

}