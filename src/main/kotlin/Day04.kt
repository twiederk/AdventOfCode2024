import java.nio.file.Path
import kotlin.io.path.name

class Day04 {

    fun loadData(path: Path): List<String> {
        return Resources.resourceAsListOfString(path.name)
    }
}