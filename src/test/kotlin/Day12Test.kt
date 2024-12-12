import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day12Test {

    private val garden1 = listOf(
        "AAAA",
        "BBCD",
        "BBCC",
        "EEEC",
    )

    @Test
    fun should_load_data() {

        // act
        val garden = Day12().loadData(Path.of("src", "test", "resources", "Day12_TestData.txt"))

        // assert
        assertThat(garden).hasSize(10)
    }

    // find all areas using bfs
    // go through each plot and check if its part of an area
    // if no, find area using bfs
    // if yes, continue with next plot

    // count fences by checking each side of each element of an area

    @Test
    fun should_find_area() {
        // arrange

        // act
        val area = Day12().area(garden1, Point2D(0, 0))

        // assert
        assertThat(area).containsOnly(
            Point2D(0, 0),
            Point2D(1, 0),
            Point2D(2, 0),
            Point2D(3, 0),
        )

    }
}