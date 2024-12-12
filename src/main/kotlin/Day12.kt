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

    fun fences(area: List<Point2D>): List<Point2D> {
        val fences = mutableListOf<Point2D>()
        for (plot in area) {
            val neighbors = plot.cardinalNeighbors()
            for (neighbor in neighbors) {
                if (!area.contains(neighbor)) {
                    fences.add(neighbor)
                }
            }
        }
        return fences
    }

    fun solvePart1(garden: List<String>): Int {
        val areas = areas(garden)
        return areas.sumOf { it.size * fences(it).size }
    }

    fun sidesHorizontal(fences: List<Point2D>): List<List<Point2D>> {
        val sides = mutableListOf<List<Point2D>>()
        var remaining = fences.toMutableList()
        var fence = remaining[0]
        while (fence in remaining) {
            val side = sideHorizontal(fence, fences)
            if (side.size > 1) {
                sides.add(side)
            }
            remaining.removeAll(side)
            if (remaining.isEmpty()) {
                break
            }
            fence = remaining[0]
        }
        return sides
    }

    fun sideHorizontal(point: Point2D, fences: List<Point2D>): List<Point2D> {
        val side = mutableListOf<Point2D>()
        side.addAll(followFence(point, fences, Point2D.EAST))
        side.addAll(followFence(point, fences, Point2D.WEST))
        side.add(point)
        return side
    }

    private fun followFence(point: Point2D, fences: List<Point2D>, direction: Point2D): List<Point2D> {
        val side = mutableListOf<Point2D>()
        var current = point
        while (current + direction in fences) {
            side.add(current + direction)
            current += direction
        }
        return side
    }

}

fun main() {
    val day12 = Day12()
    val data = day12.loadData(Path.of("src", "main", "resources", "Day12_InputData.txt"))
    println("part1: ${day12.solvePart1(data)}")
}