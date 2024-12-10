import java.nio.file.Path

class Day09 {

    fun loadData(path: Path): String {
        return Resources.resourceAsText(path.fileName.toString())
    }

    fun checksum(fileSystem: String): Int {
        return fileSystem.mapIndexed { index, char -> if (char == '.') 0 else index * char.digitToInt()  }.sum()
    }

}

