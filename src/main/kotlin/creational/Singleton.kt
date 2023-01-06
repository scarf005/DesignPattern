package creational

/**
 * Ensure a class has only one instance
 */
object FileReader {
    fun read(path: String): String {
        return FileReader::class.java.getResource(path)?.readText() ?: throw Exception("File not found: $path")
    }
}

fun main() = repeat(5) { FileReader.read("example.txt").let(::print) }
