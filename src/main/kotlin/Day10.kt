import java.nio.file.Path

class Day10 {

    fun loadData(path: Path): List<String> {
        return Resources.resourceAsListOfString(path.fileName.toString())
    }

}