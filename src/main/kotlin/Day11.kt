import java.nio.file.Path

class Day11 {

    fun loadData(path: Path): List<Long> {
        val data = Resources.resourceAsText(path.fileName.toString())
        return data.split(' ').map { it.toLong() }
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
}