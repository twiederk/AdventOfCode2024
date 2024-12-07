import java.nio.file.Path
import kotlin.io.path.name

class Day07 {

    fun loadData(path: Path): List<Equation> {
        val rawData = Resources.resourceAsListOfString(path.name)
        return rawData.map {
            Equation(
                it.substringBefore(": ").toLong(),
                it.substringAfter(": ").split(" ").map { operand -> operand.toLong() }
            )
        }
    }
}

data class Equation(
    val result: Long,
    val operands: List<Long>
)
