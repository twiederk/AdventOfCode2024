import java.nio.file.Path

class Day11 {

    fun loadData(path: Path): List<Long> {
        val data = Resources.resourceAsText(path.fileName.toString())
        return data.split(' ').map { it.toLong() }
    }

    fun executeRules(stone: Long, rules: List<Rule>): List<Long> {
        for (rule in rules) {
            if (rule.usable(stone)) {
                return rule.execute(stone)
            }
        }
        throw IllegalArgumentException("No rule found for stone $stone")
    }

    fun blink(stones: List<Long>, rules: List<Rule>): List<Long> {
        return stones.flatMap { stone -> executeRules(stone, rules) }
    }

    fun blinking(stones: List<Long>, rules: List<Rule>, numberOfBlinks: Int): List<Long> {
        var newStones = stones
        for (i in 0 until numberOfBlinks) {
            newStones = blink(newStones, rules)
        }
        return newStones
    }

    fun count(stones: List<Long>): Long {
        return stones.count().toLong()
    }

    fun solvePart1(stones: List<Long>, rules: List<Rule>, blinks: Int): Long {
        return count(blinking(stones, rules, blinks))
    }

    interface Rule {
        fun usable(stone: Long): Boolean
        fun execute(stone: Long): List<Long>
    }

    class Rule1 : Rule {

        override fun usable(stone: Long): Boolean {
            return stone == 0L
        }

        override fun execute(stone: Long): List<Long> {
            return listOf(1L)
        }
    }

    class Rule2 : Rule {

        override fun usable(stone: Long): Boolean {
            return stone.toString().length % 2 == 0
        }

        override fun execute(stone: Long): List<Long> {
            val half = stone.toString().length / 2
            val firstHalf = stone.toString().substring(0, half)
            val secondHalf = stone.toString().substring(half)
            return listOf(firstHalf.toLong(), secondHalf.toLong())
        }
    }

    class Rule3 : Rule {

        override fun usable(stone: Long): Boolean = true

        override fun execute(stone: Long): List<Long> {
            return listOf(stone * 2024)
        }
    }
}

fun main() {
    val day11 = Day11()
    val stones = day11.loadData(Path.of("src", "main", "resources", "Day11_InputData.txt"))
    val rules = listOf(Day11.Rule1(), Day11.Rule2(), Day11.Rule3())
    println("part1: ${day11.solvePart1(stones, rules, 25)}")
    println("part2: ${day11.solvePart1(stones, rules, 75)}")
}