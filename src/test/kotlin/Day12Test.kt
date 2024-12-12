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

    private val garden2 = listOf(
        "OOOOO",
        "OXOXO",
        "OOOOO",
        "OXOXO",
        "OOOOO",
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

    @Test
    fun should_find_all_areas_of_garden1() {

        // act
        val areas = Day12().areas(garden1)

        // assert
        assertThat(areas).hasSize(5)
        assertThat(areas[0]).containsOnly(
            Point2D(0, 0),
            Point2D(1, 0),
            Point2D(2, 0),
            Point2D(3, 0),
        )
        assertThat(areas[1]).containsOnly(
            Point2D(0, 1),
            Point2D(1, 1),
            Point2D(0, 2),
            Point2D(1, 2),
        )
        assertThat(areas[2]).containsOnly(
            Point2D(2, 1),
            Point2D(3, 3),
            Point2D(2, 2),
            Point2D(3, 2),
        )
        assertThat(areas[3]).containsOnly(
            Point2D(3, 1),
        )
        assertThat(areas[4]).containsOnly(
            Point2D(0, 3),
            Point2D(1, 3),
            Point2D(2, 3),
        )
    }

    @Test
    fun should_find_all_areas_of_garden2() {

        // act
        val areas = Day12().areas(garden2)

        // assert
        assertThat(areas).hasSize(5)
    }

}