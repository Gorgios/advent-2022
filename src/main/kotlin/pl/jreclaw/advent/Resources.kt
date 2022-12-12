package pl.jreclaw.advent


import java.io.File
import java.net.URI

internal object Resources {

    fun fileAsString(fileName: String): String =
        File(fileName.toURI()).readText()

    fun fileAsListOfString(fileName: String): List<String> =
        File(fileName.toURI()).readLines()

    fun fileAsListOfSplitString(fileName: String, delimiter: String): List<List<String>> =
        File(fileName.toURI()).readLines().map { it.split(delimiter) }

    fun fileAsChar2dArray(fileName: String): Array<Array<Char>> {
        val lines = File(fileName.toURI()).readLines()
        return Array(lines.size){ i ->
            Array(lines[0].length) { j ->
                lines[i][j]
            }
        }
    }
    private fun String.toURI(): URI =
        Resources.javaClass.classLoader.getResource(this)?.toURI()
            ?: throw IllegalArgumentException("Cannot find file: $this")
}