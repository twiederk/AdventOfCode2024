import java.nio.file.Path
import kotlin.io.path.name


class Day06 {


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

    fun step(position: Point2D, direction: Point2D, grid: List<String>): Pair<Point2D,Point2D> {
        return if (isBlocked(position + direction, grid)) {
            Pair(position, turn(direction))
        } else {
            Pair(move(position, direction, grid), direction)
        }
    }

    companion object {
        val END_POINT = Point2D(-1, -1)
    }

}