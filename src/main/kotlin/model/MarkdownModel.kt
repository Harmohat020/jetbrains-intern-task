package model

import java.io.File
import java.nio.file.Files

class MarkdownModel {
    fun loadFile(file: File): String {
        return Files.readAllLines(file.toPath()).joinToString("\n")
    }

    fun validateFile(file: File): Boolean {
        return file.extension.equals("md", ignoreCase = true)
    }
}