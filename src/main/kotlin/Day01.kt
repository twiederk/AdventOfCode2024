import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.name
import kotlin.math.abs

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

    fun sortData(first: List<Int>, second: List<Int>): Pair<List<Int>, List<Int>> {
        return Pair(first.sorted(), second.sorted())
    }

    fun calcDistance(start: Int, end: Int): Int {
        return abs(end - start)
    }

    fun sumUpDistance(first: List<Int>, second: List<Int>): Int {
        var sum = 0
        for (i in first.indices) {
            sum += calcDistance(first[i], second[i])
        }
        return sum
    }

    fun part1(first: List<Int>, second: List<Int>): Int {
        val sorted = sortData(first, second)
        return sumUpDistance(sorted.first, sorted.second)
    }

    fun countNumberInList(list: List<Int>, number: Int): Int {
        return list.count { it == number }
    }

    fun multiplyNumberWithCountOfNumberInList(list: List<Int>, number: Int): Int {
        return countNumberInList(list, number) * number
    }

    fun part2(first: List<Int>, second: List<Int>): Int {
        var sum = 0
        for (i in first.indices) {
            sum += multiplyNumberWithCountOfNumberInList(second, first[i])
        }
        return sum
    }

}

fun main() {
    val day1 = Day01()
    val listsOfIds = day1.loadData(Path("src", "main", "resources", "Day01_InputData.txt"))
    val part1 = day1.part1(listsOfIds.first, listsOfIds.second)
    println("Day01 part1:  $part1")

    val part2 = day1.part2(listsOfIds.first, listsOfIds.second)
    println("Day01 part2:  $part2")
}
