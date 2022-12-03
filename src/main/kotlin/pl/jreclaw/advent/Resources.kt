package pl.jreclaw.advent


import java.io.File
import java.net.URI

internal object Resources {
    fun fileAsListOfString(fileName: String): List<String> =
        File(fileName.toURI()).readLines()

    private fun String.toURI(): URI =
        Resources.javaClass.classLoader.getResource(this)?.toURI()
            ?: throw IllegalArgumentException("Cannot find file: $this")
}