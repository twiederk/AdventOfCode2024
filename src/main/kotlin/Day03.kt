import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.name

class Day03 {

    fun loadData(path: Path): List<String> {
        return Resources.resourceAsListOfString(path.name)
    }

    fun findMultiplicators(input: String): List<Pair<Int, Int>> {
        val multiplicators = mutableListOf<Pair<Int, Int>>()

        val regex = Regex("""mul\(\d{1,3},\d{1,3}\)""")
        val matches = regex.findAll(input)
        for (match in matches) {
            val firstDigit = match.value.substringAfter("mul(").substringBefore(",")
            val secondDigit = match.value.substringAfter(",").substringBefore(")")
            multiplicators.add(Pair(firstDigit.toInt(), secondDigit.toInt()))
        }
        return multiplicators.toList()
    }

    fun sumUpMultiplicators(multiplicators: List<Pair<Int, Int>>): Int {
        return multiplicators.sumOf { it.first * it.second }
    }

    fun solvePart1(memory: List<String>): Int {
        val multiplicators = memory.map { findMultiplicators(it) }.flatten()
        val sum = sumUpMultiplicators(multiplicators)
        return sum
    }

}

fun main() {
    val memory = Day03().loadData(Path("src", "main", "resources", "Day03_InputData.txt"))
    val result = Day03().solvePart1(memory)
    println("part1: $result")
}