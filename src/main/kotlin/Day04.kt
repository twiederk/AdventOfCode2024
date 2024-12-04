import java.nio.file.Path
import kotlin.io.path.name

class Day04 {

    private val letterMap = mapOf(
        'X' to 'M',
        'M' to 'A',
        'A' to 'S'
    )


    fun loadData(path: Path): List<String> {
        return Resources.resourceAsListOfString(path.name)
    }

    fun bfs(wordPuzzle: List<String>): Int {
        /*
        val queue = LinkedList<Work>()
        queue.add(Work(startingPosition, 0))
        val finalSteps = mutableListOf<Work>()

        while (queue.isNotEmpty()) {
            val current = queue.remove()
            if (current.steps == maxSteps) {
                finalSteps.add(current)
                continue
            }
            current.position.cardinalNeighbors(mapOfGarden)
                .filter { !isRock(mapOfGarden, it) }
                .filter { it !in queue.map { queueElement -> queueElement.position } }
                .forEach {
                    queue.add(Work(it, current.steps + 1))
                }
        }
        return finalSteps.map { it.position }
         */

        return 0
    }

    fun letter(point: Point2D, wordPuzzle: List<String>): Char {
        return wordPuzzle[point.y][point.x]
    }

    fun neighbours(point: Point2D, wordPuzzle: List<String>): List<Point2D> {
        val allNeighbors = point.allNeighbors(wordPuzzle)
        val nextLetter = letterMap[letter(point, wordPuzzle)]
        return allNeighbors.filter { letter(it, wordPuzzle) == nextLetter }
    }
}