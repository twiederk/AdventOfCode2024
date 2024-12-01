import java.nio.file.Path
import kotlin.io.path.name

class Day01 {

    fun loadData(path: Path): Pair<List<Int>, List<Int>> {
        val first = mutableListOf<Int>()
        val second = mutableListOf<Int>()
        Resources.resourceAsListOfString(path.name).map {
            val values = it.split("   ")
            first.add(values[0].toInt())
            second.add(values[1].toInt())
        }
        return Pair(first, second)
    }
}