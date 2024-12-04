import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.name

class Day04 {

    private val letterMap = mapOf(
        'X' to 'M',
        'M' to 'A',
        'A' to 'S'
    )

    private val directions = listOf(
        Point2D.NORTH,
        Point2D.NORTH_EAST,
        Point2D.EAST,
        Point2D.SOUTH_EAST,
        Point2D.SOUTH,
        Point2D.SOUTH_WEST,
        Point2D.WEST,
        Point2D.NORTH_WEST
    )


    fun loadData(path: Path): List<String> {
        return Resources.resourceAsListOfString(path.name)
    }

    fun letter(point: Point2D, wordPuzzle: List<String>): Char {
        if (point.x < 0 || point.y < 0 || point.y >= wordPuzzle.size || point.x >= wordPuzzle[point.y].length) {
            return '-'
        }
        return wordPuzzle[point.y][point.x]
    }

    fun neighbours(point: Point2D, wordPuzzle: List<String>): List<Point2D> {
        val allNeighbors = point.allNeighbors(wordPuzzle)
        val nextLetter = letterMap[letter(point, wordPuzzle)]
        return allNeighbors.filter { letter(it, wordPuzzle) == nextLetter }
    }

    fun startingPoints(wordPuzzle: List<String>, letter: Char): List<Point2D> {
        val startingPoints = mutableListOf<Point2D>()
        for (y in wordPuzzle.indices) {
            for (x in wordPuzzle[y].indices) {
                if (letter(Point2D(x, y), wordPuzzle) == letter) {
                    startingPoints.add(Point2D(x, y))
                }
            }
        }
        return startingPoints
    }

    fun word(point: Point2D, direction: Point2D, worldPuzzle: List<String>): Boolean {
        return (letter(point + direction, worldPuzzle) == 'M'
                && letter(point + direction + direction, worldPuzzle) == 'A'
                && letter(point + direction + direction + direction, worldPuzzle) == 'S')
    }

    fun numberOfWords(point: Point2D, wordPuzzle: List<String>): Int {
        var numberOfWords = 0
        for (direction in directions) {
            if (word(point, direction, wordPuzzle)) {
                numberOfWords++
            }
        }
        return numberOfWords
    }

    fun solvePart1(wordPuzzle: List<String>): Int {
        var count = 0
        for (point in startingPoints(wordPuzzle, 'X')) {
            count += numberOfWords(point, wordPuzzle)
        }
        return count
    }

}

fun main() {
    val day04 = Day04()
    val wordPuzzle = Day03().loadData(Path("src", "main", "resources", "Day04_InputData.txt"))
    println("Part 1: ${day04.solvePart1(wordPuzzle)}")
}