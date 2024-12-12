import java.nio.file.Path

class Day12 {

    fun loadData(path: Path): List<String> {
        return Resources.resourceAsListOfString(path.fileName.toString())
    }

    fun plant(garden: List<String>, plot: Point2D): Char {
        return garden[plot.y][plot.x]
    }

    fun area(garden: List<String>, start: Point2D): List<Point2D> {
        val area = mutableListOf<Point2D>()
        val visited = mutableSetOf<Point2D>()
        val queue = mutableListOf<Point2D>()

        queue.add(start)
        val plant = plant(garden, start)

        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            if (visited.contains(current)) {
                continue
            }
            visited.add(current)
            area.add(current)

            val neighbors = current.cardinalNeighbors().filter { isSafe(garden, it, plant) }
            queue.addAll(neighbors)
        }
        return area
    }

    fun isSafe(garden: List<String>, plot: Point2D, plant: Char): Boolean {
        return plot.x >= 0 && plot.y >= 0 && plot.x < garden.size && plot.y < garden[0].length
                && plant == plant(garden, plot)
    }

    fun areas(garden: List<String>): List<List<Point2D>> {
        val areas = mutableListOf<List<Point2D>>()
        for (y in garden.indices) {
            for (x in garden[y].indices) {
                val plot = Point2D(x, y)
                if (areas.any { it.contains(plot) }) {
                    continue
                }
                val area = area(garden, plot)
                areas.add(area)
            }
        }
        return areas
    }

}