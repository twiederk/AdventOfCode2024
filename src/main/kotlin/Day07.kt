import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.name
import kotlin.math.pow

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
                "*" -> total *= equation.operands[i]
                "|" -> total = "${total}${equation.operands[i]}".toLong()
            }
        }
        return total == equation.result
    }


    fun checkEquationWithAllPermutations(equation: Equation, base: Int): Boolean {
        val numberOfPermutations = equation.numberOfPermutations(base)
        for (counter in 0 until numberOfPermutations) {
            if (evaluate(equation, convertLongToPermutation(counter, equation.operands.size, base))) {
                return true
            }
        }
        return false
    }

    fun solvePart1(equations: List<Equation>): Long {
        return equations.filter { equation -> checkEquationWithAllPermutations(equation, 2) }.sumOf { it.result }
    }

    fun convertLongToPermutation(number: Long, numberOfOperators: Int, base: Int): List<String> {
        val permutations = mutableListOf<String>()
        val binaryRepresentation = number.toString(base).padStart(numberOfOperators, '0')
        for (digit in binaryRepresentation) {
            if (digit == '0') {
                permutations.add("+")
            } else if (digit == '1') {
                permutations.add("*")
            } else {
                permutations.add("|")
            }
        }
        return permutations
    }

    fun solvePart2(equations: List<Equation>): Long {
        return equations.filter { equation -> checkEquationWithAllPermutations(equation, 3) }.sumOf { it.result }
    }

}

data class Equation(
    val result: Long,
    val operands: List<Long>
) {
    fun numberOfPermutations(base: Int): Long {
        return base.toDouble().pow((operands.size).toDouble()).toLong()
    }
}

fun main() {
    val day07 = Day07()
    val equations = day07.loadData(Path("src", "main", "resources", "Day07_InputData.txt"))
    println("Part 1: ${day07.solvePart1(equations)}")
    println("Part 2: ${day07.solvePart2(equations)}")
}