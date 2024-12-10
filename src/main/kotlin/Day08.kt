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
}