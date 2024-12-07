import java.nio.file.Path
import kotlin.io.path.Path
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

    fun evaluate(equation: Equation, operators: List<String>): Boolean {
        var total = equation.operands[0]
        for (i in 1..<equation.operands.size) {
            when (operators[i - 1]) {
                "+" -> total += equation.operands[i]
                "-" -> total -= equation.operands[i]
                "*" -> total *= equation.operands[i]
                "/" -> total /= equation.operands[i]
            }
        }
        return total == equation.result
    }

    fun generateAllPermutations(numberOfOperants: Int): List<List<String>> {
        when (numberOfOperants) {
            2 -> return listOf(
                listOf("+"),
                listOf("*")
            )

            3 -> return listOf(
                listOf("+", "+"),
                listOf("+", "*"),
                listOf("*", "+"),
                listOf("*", "*")
            )

            4 -> return listOf(
                listOf("+", "+", "+"),
                listOf("+", "+", "*"),
                listOf("+", "*", "+"),
                listOf("+", "*", "*"),
                listOf("*", "+", "+"),
                listOf("*", "+", "*"),
                listOf("*", "*", "+"),
                listOf("*", "*", "*")
            )

            5 -> return listOf(
                listOf("+", "+", "+", "+"),
                listOf("+", "+", "+", "*"),
                listOf("+", "+", "*", "+"),
                listOf("+", "+", "*", "*"),
                listOf("+", "*", "+", "+"),
                listOf("+", "*", "+", "*"),
                listOf("+", "*", "*", "+"),
                listOf("+", "*", "*", "*"),
                listOf("*", "+", "+", "+"),
                listOf("*", "+", "+", "*"),
                listOf("*", "+", "*", "+"),
                listOf("*", "+", "*", "*"),
                listOf("*", "*", "+", "+"),
                listOf("*", "*", "+", "*"),
                listOf("*", "*", "*", "+"),
                listOf("*", "*", "*", "*")
            )

            6 -> return listOf(
                listOf("+", "+", "+", "+", "+"),
                listOf("+", "+", "+", "+", "*"),
                listOf("+", "+", "+", "*", "+"),
                listOf("+", "+", "+", "*", "*"),
                listOf("+", "+", "*", "+", "+"),
                listOf("+", "+", "*", "+", "*"),
                listOf("+", "+", "*", "*", "+"),
                listOf("+", "+", "*", "*", "*"),
                listOf("+", "*", "+", "+", "+"),
                listOf("+", "*", "+", "+", "*"),
                listOf("+", "*", "+", "*", "+"),
                listOf("+", "*", "+", "*", "*"),
                listOf("+", "*", "*", "+", "+"),
                listOf("+", "*", "*", "+", "*"),
                listOf("+", "*", "*", "*", "+"),
                listOf("+", "*", "*", "*", "*"),
                listOf("*", "+", "+", "+", "+"),
                listOf("*", "+", "+", "+", "*"),
                listOf("*", "+", "+", "*", "+"),
                listOf("*", "+", "+", "*", "*"),
                listOf("*", "+", "*", "+", "+"),
                listOf("*", "+", "*", "+", "*"),
                listOf("*", "+", "*", "*", "+"),
                listOf("*", "+", "*", "*", "*"),
                listOf("*", "*", "+", "+", "+"),
                listOf("*", "*", "+", "+", "*"),
                listOf("*", "*", "+", "*", "+"),
                listOf("*", "*", "+", "*", "*"),
                listOf("*", "*", "*", "+", "+"),
                listOf("*", "*", "*", "+", "*"),
                listOf("*", "*", "*", "*", "+"),
                listOf("*", "*", "*", "*", "*")
            )

            7 -> return listOf(
                listOf("+", "+", "+", "+", "+", "+"),
                listOf("+", "+", "+", "+", "+", "*"),
                listOf("+", "+", "+", "+", "*", "+"),
                listOf("+", "+", "+", "+", "*", "*"),
                listOf("+", "+", "+", "*", "+", "+"),
                listOf("+", "+", "+", "*", "+", "*"),
                listOf("+", "+", "+", "*", "*", "+"),
                listOf("+", "+", "+", "*", "*", "*"),
                listOf("+", "+", "*", "+", "+", "+"),
                listOf("+", "+", "*", "+", "+", "*"),
                listOf("+", "+", "*", "+", "*", "+"),
                listOf("+", "+", "*", "+", "*", "*"),
                listOf("+", "+", "*", "*", "+", "+"),
                listOf("+", "+", "*", "*", "+", "*"),
                listOf("+", "+", "*", "*", "*", "+"),
                listOf("+", "+", "*", "*", "*", "*"),
                listOf("+", "*", "+", "+", "+", "+"),
                listOf("+", "*", "+", "+", "+", "*"),
                listOf("+", "*", "+", "+", "*", "+"),
                listOf("+", "*", "+", "+", "*", "*"),
                listOf("+", "*", "+", "*", "+", "+"),
                listOf("+", "*", "+", "*", "+", "*"),
                listOf("+", "*", "+", "*", "*", "+"),
                listOf("+", "*", "+", "*", "*", "*"),
                listOf("+", "*", "*", "+", "+", "+"),
                listOf("+", "*", "*", "+", "+", "*"),
                listOf("+", "*", "*", "+", "*", "+"),
                listOf("+", "*", "*", "+", "*", "*"),
                listOf("+", "*", "*", "*", "+", "+"),
                listOf("+", "*", "*", "*", "+", "*"),
                listOf("+", "*", "*", "*", "*", "+"),
                listOf("+", "*", "*", "*", "*", "*"),
                listOf("*", "+", "+", "+", "+", "+"),
                listOf("*", "+", "+", "+", "+", "*"),
                listOf("*", "+", "+", "+", "*", "+"),
                listOf("*", "+", "+", "+", "*", "*"),
                listOf("*", "+", "+", "*", "+", "+"),
                listOf("*", "+", "+", "*", "+", "*"),
                listOf("*", "+", "+", "*", "*", "+"),
                listOf("*", "+", "+", "*", "*", "*"),
                listOf("*", "+", "*", "+", "+", "+"),
                listOf("*", "+", "*", "+", "+", "*"),
                listOf("*", "+", "*", "+", "*", "+"),
                listOf("*", "+", "*", "+", "*", "*"),
                listOf("*", "+", "*", "*", "+", "+"),
                listOf("*", "+", "*", "*", "+", "*"),
                listOf("*", "+", "*", "*", "*", "+"),
                listOf("*", "+", "*", "*", "*", "*"),
                listOf("*", "*", "+", "+", "+", "+"),
                listOf("*", "*", "+", "+", "+", "*"),
                listOf("*", "*", "+", "+", "*", "+"),
                listOf("*", "*", "+", "+", "*", "*"),
                listOf("*", "*", "+", "*", "+", "+"),
                listOf("*", "*", "+", "*", "+", "*"),
                listOf("*", "*", "+", "*", "*", "+"),
                listOf("*", "*", "+", "*", "*", "*"),
                listOf("*", "*", "*", "+", "+", "+"),
                listOf("*", "*", "*", "+", "+", "*"),
                listOf("*", "*", "*", "+", "*", "+"),
                listOf("*", "*", "*", "+", "*", "*"),
                listOf("*", "*", "*", "*", "+", "+"),
                listOf("*", "*", "*", "*", "+", "*"),
                listOf("*", "*", "*", "*", "*", "+"),
                listOf("*", "*", "*", "*", "*", "*")
            )

            else -> throw IllegalArgumentException("Too many operands: $numberOfOperants")
        }
    }

    fun checkEquationWithAllPermutations(equation: Equation): Boolean {
        val permutations = generateAllPermutations(equation.operands.size)
        for (permutation in permutations) {
            if (evaluate(equation, permutation)) {
                return true
            }
        }
        return false
    }

    fun solvePart1(equations: List<Equation>): Long {
        return equations.filter { equation -> checkEquationWithAllPermutations(equation) }.sumOf { it.result }
    }
}

data class Equation(
    val result: Long,
    val operands: List<Long>
)

fun main() {
    val day07 = Day07()
    val equations = day07.loadData(Path("src", "main", "resources", "Day07_InputData.txt"))
    println("Part 1: ${day07.solvePart1(equations)}")
}