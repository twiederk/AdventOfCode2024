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
        val newStones = mutableListOf<Long>()
        for (stone in stones) {
            newStones.addAll(executeRules(stone, rules))
        }
        return newStones
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