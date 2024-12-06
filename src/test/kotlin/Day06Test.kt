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

    @Test
    fun should_move_to_next_position_when_not_blocked() {

        // act
        val (position, direction) = Day06().step(Point2D(4, 6), Point2D.NORTH, grid)

        // assert
        assertThat(position).isEqualTo(Point2D(4, 5))
        assertThat(direction).isEqualTo(Point2D.NORTH)
    }

    @Test
    fun should_turn_to_next_position_when_not_blocked() {

        // act
        val (position, direction) = Day06().step(Point2D(4, 1), Point2D.NORTH, grid)

        // assert
        assertThat(position).isEqualTo(Point2D(4, 1))
        assertThat(direction).isEqualTo(Point2D.EAST)
    }

    @Test
    fun should_END_POINT_when_leaving_grid() {
        // act
        val (position, direction) = Day06().step(Point2D(0, 0), Point2D.NORTH, grid)

        // assert
        assertThat(position).isEqualTo(Day06.END_POINT)
        assertThat(direction).isEqualTo(Point2D.NORTH)
    }

    @Test
    fun should_storePosition_X_to_grid() {
        // arrange
        val day06 = Day06()

        // act
        val result = day06.storePosition(Point2D(1, 1))

        // assert
        assertThat(result).containsExactly(Point2D(1, 1))
    }

    @Test
    fun should_storePosition_path_on_empty_grid() {
        // arrange
        val grid = listOf(
            "...",
            "...",
            ".^.",
        )

        // act
        val result = Day06().patrol(grid)

        // assert
        assertThat(result).contains(
            Point2D(1,0),
            Point2D(1,1),
            Point2D(1,2),
        )
    }

    @Test
    fun should_count_all_X_on_grid() {
        val patrolMap = listOf(
            "....#.....",
            "....XXXXX#",
            "....X...X.",
            "..#.X...X.",
            "..XXXXX#X.",
            "..X.X.X.X.",
            ".#XXXXXXX.",
            ".XXXXXXX#.",
            "#XXXXXXX..",
            "......#X..",
        )

        // act
        val result = Day06().countX(patrolMap)

        // assert
        assertThat(result).isEqualTo(41)
    }

    @Test
    fun should_solve_part1() {

        // act
        val result = Day06().solvePart1(grid)

        // assert
        assertThat(result).isEqualTo(41)
    }

}