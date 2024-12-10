import java.nio.file.Path

class Day09 {

    fun loadData(path: Path): String {
        return Resources.resourceAsText(path.fileName.toString())
    }

    fun checksum(fileSystem: String): Int {
        return fileSystem.mapIndexed { index, char -> if (char == '.') 0 else index * char.digitToInt()  }.sum()
    }

    fun createFileSystem(size: Int): String {
        return ".".repeat(size)
    }

    fun createFileBlocks(fileSystem: String): List<FileBlock> {
        return fileSystem.mapIndexed { index, char ->
            if (index % 2 == 0) {
                FileBlock(index, char, char.digitToInt())
            } else {
                FileBlock(index, '.', char.digitToInt())
            }
        }
    }
}

data class FileBlock(
    val id: Int,
    val content: Char,
    val size: Int
)
