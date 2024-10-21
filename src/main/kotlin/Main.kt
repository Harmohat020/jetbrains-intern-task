import controller.MarkdownController
import model.MarkdownModel
import presentation.MainFrame

fun main(args: Array<String>) {
    val mainFrame = MainFrame()
    val markdownModel = MarkdownModel()
    val markdownController = MarkdownController(markdownModel, mainFrame)

    mainFrame.isVisible = true
}