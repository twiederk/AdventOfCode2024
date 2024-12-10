import java.nio.file.Path

class Day10 {

    fun loadData(path: Path): List<String> {
        return Resources.resourceAsListOfString(path.fileName.toString())
    }

    fun trailheads(grid: List<String>): List<Point2D> {
        val trailheads = mutableListOf<Point2D>()
        grid.forEachIndexed { y, row ->
            row.forEachIndexed { x, cell ->
                if (cell == '0') {
                    trailheads.add(Point2D(x, y))
                }
            }
        }
        return trailheads
    }

    fun score(grid: List<String>, trailhead: Point2D): Int {
        val targets = mutableSetOf<Point2D>()
        val visited = mutableSetOf<Point2D>()
        val queue = mutableListOf(trailhead)
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            if (height(current, grid) == 9) {
                targets.add(current)
                continue
            }
            if (visited.contains(current)) {
                continue
            }
            visited.add(current)
            val neighbours = current.cardinalNeighbors()
            val currentHeight = height(current, grid)
            neighbours.forEach { neighbour ->
                if (isSafe(neighbour, currentHeight, grid)) {
                    queue.add(neighbour)
                }
            }
        }
        return targets.size
    }

    fun isSafe(position: Point2D, currentHeight: Int, grid: List<String>): Boolean {
        val xRange = 0..<grid[0].length
        val yRange = 0..<grid.size
        return position.x in xRange && position.y in yRange && currentHeight + 1 == height(position, grid)
    }

    fun height(position: Point2D, grid: List<String>): Int {
        val char = grid[position.y][position.x]
        return if (char == '.') -1 else {
            char.digitToInt()
        }
    }

}