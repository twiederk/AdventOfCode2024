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

}