import java.nio.file.Path

class Day08 {

    fun loadData(path: Path): List<String> {
        return Resources.resourceAsListOfString(path.fileName.toString())
    }

    fun antennas(grid: List<String>): Map<Char, List<Point2D>> {
        val antennas = mutableMapOf<Char, MutableList<Point2D>>()
        grid.forEachIndexed { y, row ->
            row.forEachIndexed { x, cell ->
                if (cell != '.') {
                    val points = antennas.getOrDefault(cell, mutableListOf())
                    points += Point2D(x, y)
                    antennas[cell] = points
                }
            }
        }
        return antennas
    }

    fun antinodes(antennas: List<Point2D>, grid: List<String>): Set<Point2D> {
        val antinodes = mutableSetOf<Point2D>()
        for (antenna in antennas) {
            for (other in antennas) {
                if (antenna != other) {
                    val vector = antenna - other
                    val antinode = antenna + vector
                    if (antinode.x >= 0 && antinode.x < grid[0].length && antinode.y >= 0 && antinode.y < grid.size) {
                        antinodes.add(antinode)
                    }
                }
            }
        }
        return antinodes
    }

    fun antinodesResonantHarmonics(antennas: List<Point2D>, grid: List<String>): Set<Point2D> {
        val antinodes = mutableSetOf<Point2D>()
        for (antenna in antennas) {
            for (other in antennas) {
                if (antenna != other) {
                    val vector = antenna - other
                    var antinode = antenna + vector
                    while (antinode.x >= 0 && antinode.x < grid[0].length && antinode.y >= 0 && antinode.y < grid.size) {
                        antinodes.add(antinode)
                        antinode += vector
                    }
                }
            }
        }
        return antinodes
    }

    fun solvePart1(grid: List<String>): Int {
        val antinodes = mutableSetOf<Point2D>()
        val antennas = antennas(grid)
        antennas.values.forEach { antinodes += antinodes(it, grid) }
        return antinodes.size
    }

    fun solvePart2(grid: List<String>): Int {
        val antinodes = mutableSetOf<Point2D>()
        val antennas = antennas(grid)
        antennas.values.forEach { antinodes += antinodesResonantHarmonics(it, grid) }
        antinodes += antennas.values.flatten()
        return antinodes.size
    }
}

fun main() {
    val grid = Day08().loadData(Path.of("src", "main", "resources", "Day08_InputData.txt"))
    println("part1: ${Day08().solvePart1(grid)}")
    println("part2: ${Day08().solvePart2(grid)}")
}