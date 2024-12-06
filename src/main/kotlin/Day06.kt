import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.name


class Day06 {

    private val visited = mutableSetOf<Point2D>()
    private val visitedWithDirection = mutableSetOf<Pair<Point2D, Point2D>>()

    private val turns = mapOf(
        Point2D.NORTH to Point2D.EAST,
        Point2D.EAST to Point2D.SOUTH,
        Point2D.SOUTH to Point2D.WEST,
        Point2D.WEST to Point2D.NORTH,
    )

    fun loadData(path: Path): List<String> {
        return Resources.resourceAsListOfString(path.name)
    }

    fun startPoint(grid: List<String>): Point2D {
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                if (grid[y][x] == '^') {
                    return Point2D(x, y)
                }
            }
        }
        throw IllegalArgumentException("No start point found")
    }

    fun isBlocked(position: Point2D, grid: List<String>): Boolean {
        if (position.x < 0 || position.y < 0 || position.y >= grid.size || position.x >= grid[position.y].length) {
            return false
        }
        return grid[position.y][position.x] == '#'
    }

    fun move(position: Point2D, direction: Point2D, grid: List<String>): Point2D {
        val newPosition = position + direction
        if (newPosition.x < 0 || newPosition.y < 0 || newPosition.y >= grid.size || newPosition.x >= grid[newPosition.y].length) {
            return END_POINT
        }
        return newPosition
    }

    fun turn(direction: Point2D): Point2D {
        return turns[direction] ?: throw IllegalArgumentException("Invalid direction")
    }

    fun step(position: Point2D, direction: Point2D, grid: List<String>): Pair<Point2D, Point2D> {
        return if (isBlocked(position + direction, grid)) {
            Pair(position, turn(direction))
        } else {
            Pair(move(position, direction, grid), direction)
        }
    }

    fun storePosition(position: Point2D): Set<Point2D> {
        visited.add(position)
        return visited
    }

    fun patrol(grid: List<String>): Set<Point2D> {
        val startPoint = startPoint(grid)
        storePosition(startPoint)
        var position = startPoint
        var direction = Point2D.NORTH
        while (position != END_POINT) {
            val (newPosition, newDirection) = step(position, direction, grid)
            position = newPosition
            direction = newDirection
            if (position != END_POINT) {
                storePosition(position)
            }
        }
        return visited
    }

    private fun patrolWithDirection(grid: List<String>, startPoint: Point2D): Boolean {
        var position = startPoint
        var direction = Point2D.NORTH
        storePositionWithDirection(position, direction)
        while (position != END_POINT) {
            val (newPosition, newDirection) = step(position, direction, grid)
            position = newPosition
            direction = newDirection
            if (position != END_POINT) {
                try {
                    storePositionWithDirection(position, direction)
                } catch (e: Exception) {
                    visitedWithDirection.clear()
                    return true
                }
            }
        }
        visitedWithDirection.clear()
        return false
    }

    fun solvePart2(grid: List<String>): Int {
        var loops = 0
        val startPoint = startPoint(grid)
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                if (grid[y][x] != '#') {
                    val newGrid = addObstacle(grid, Point2D(x, y))
                    if (patrolWithDirection(newGrid, startPoint)) {
                        loops++
                    }
                }
            }
        }
        return loops
    }


    fun countX(grid: List<String>): Int {
        return grid.sumOf { it.count { c -> c == 'X' } }
    }

    fun solvePart1(grid: List<String>): Int {
        return patrol(grid).size
    }

    fun storePositionWithDirection(position: Point2D, direction: Point2D): Set<Pair<Point2D, Point2D>> {
        if (visitedWithDirection.contains(Pair(position, direction))) {
            throw Exception("Loop detected")
        }
        visitedWithDirection.add(Pair(position, direction))
        return visitedWithDirection
    }

    fun addObstacle(grid: List<String>, position: Point2D): List<String> {
        val row = grid[position.y].toCharArray()
        row[position.x] = '#'
        val newGrid = grid.toMutableList()
        newGrid[position.y] = String(row)
        return newGrid
    }


    companion object {
        val END_POINT = Point2D(-1, -1)
    }

}

fun main() {
    val day06 = Day06()
    val grid = day06.loadData(Path("src", "main", "resources", "Day06_InputData.txt"))
    println("Part 1: ${day06.solvePart1(grid)}")
    println("Part 2: ${day06.solvePart2(grid)}")
}