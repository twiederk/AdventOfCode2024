import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.name

class Day02 {

    fun loadData(path: Path): List<List<Int>> {
        return Resources.resourceAsListOfString(path.name).map { it.split(" ").map { it.toInt() } }
    }

    fun diffs(report: List<Int>): List<Int> {
        return report.windowed(size = 2, step = 1, partialWindows = false, transform = { it[1] - it[0] })
    }

    fun validDecrease(diffs: List<Int>): Boolean {
        return diffs.all { it in -3..-1 }
    }

    fun validIncrease(diffs: List<Int>): Boolean {
        return diffs.all { it in 1..3 }
    }

    fun validReport(report: List<Int>): Boolean {
        val diffs = diffs(report)
        return validDecrease(diffs) || validIncrease(diffs)
    }

    fun part1(reports: List<List<Int>>): Int {
        return reports.count { Day02().validReport(it) }
    }

    fun validDampenerIncrease(diffs: List<Int>): Boolean {
        val filteredDiffs = diffs.filter { it in 1..3 }
        return filteredDiffs.size == diffs.size || filteredDiffs.size == diffs.size - 1
    }

    fun validDampenerDecrease(diffs: List<Int>): Boolean {
        val filteredDiffs = diffs.filter { it in -3..-1 }
        return filteredDiffs.size == diffs.size || filteredDiffs.size == diffs.size - 1
    }

    fun validDampenerReport(report: List<Int>): Boolean {
        val diffs = diffs(report)
        return validDampenerDecrease(diffs) || validDampenerIncrease(diffs)
    }

    fun part2(reports: List<List<Int>>): Int {
        return reports.count { Day02().validDampenerReport(it) }
    }


}

fun main() {
    val day2 = Day02()
    val reports = day2.loadData(Path("src", "main", "resources", "Day02_InputData.txt"))
    println("part1: ${day2.part1(reports)}")
    println("part2: ${day2.part2(reports)}")
}