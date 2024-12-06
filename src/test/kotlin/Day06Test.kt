import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path


class Day06Test {

    val grid = listOf(
        "....#.....",
        ".........#",
        "..........",
        "..#.......",
        ".......#..",
        "..........",
        ".#..^.....",
        "........#.",
        "#.........",
        "......#...",
    )

    @Test
    fun should_load_data() {

        // act
        val grid = Day06().loadData(Path("src", "test", "resources", "Day06_TestData.txt"))

        // assert
        assertThat(grid).hasSize(10)
    }

    @Test
    fun should_find_start_position() {

        // act
        val startPoint = Day06().startPoint(grid)

        // assert
        assertThat(startPoint).isEqualTo(Point2D(4, 6))
    }

    @Test
    fun should_return_false_when_position_is_not_blocked() {

        // act
        val blocked = Day06().isBlocked(Point2D(0, 0), grid)

        // assert
        assertThat(blocked).isFalse()
    }

    @Test
    fun should_return_true_when_position_is_blocked() {

        // act
        val blocked = Day06().isBlocked(Point2D(4, 0), grid)

        // assert
        assertThat(blocked).isTrue()
    }

    @Test
    fun should_move_when_direction_is_given() {

        // act
        val result = Day06().move(Point2D(4, 6), Point2D.NORTH, grid)

        // assert
        assertThat(result).isEqualTo(Point2D(4, 5))
    }

    @Test
    fun should_return_END_POINT_when_moving_of_gird() {

        // act
        val result = Day06().move(Point2D(0, 0), Point2D.NORTH, grid)

        // assert
        assertThat(result).isEqualTo(Day06.END_POINT)

    }

    @Test
    fun should_turn_east_when_direction_is_north() {

        // act
        val result = Day06().turn(Point2D.NORTH)

        // assert
        assertThat(result).isEqualTo(Point2D.EAST)
    }

}