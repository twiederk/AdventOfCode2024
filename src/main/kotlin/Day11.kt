import java.nio.file.Path

class Day11 {

    fun loadData(path: Path): List<Long> {
        val data = Resources.resourceAsText(path.fileName.toString())
        return data.split(' ').map { it.toLong() }
    }
}