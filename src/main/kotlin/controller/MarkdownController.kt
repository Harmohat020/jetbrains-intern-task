package controller

import model.MarkdownModel
import presentation.MainFrame
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JFileChooser
import javax.swing.JOptionPane
import javax.swing.filechooser.FileNameExtensionFilter

class MarkdownController(private val model: MarkdownModel, private val frame: MainFrame) {
    init {
        frame.loadFileButton.addActionListener(object: ActionListener {
            override fun actionPerformed(e: ActionEvent?) {
                val fileChooser = JFileChooser()
                fileChooser.fileFilter = FileNameExtensionFilter("Markdown file", "md")

                if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    val file = fileChooser.selectedFile

                    if (model.validateFile(file)) {
                        val content = model.loadFile(file)
                        frame.showFileContent(content)
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid file type, please select a .md file.")
                    }
                }
            }
        })
    }
}