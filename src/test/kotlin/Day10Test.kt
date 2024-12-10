import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day10Test {

    private val example_1 = listOf(
        "0123",
        "1234",
        "8765",
        "9876",
    )

    private val example_2 = listOf(
        "...0...",
        "...1...",
        "...2...",
        "6543456",
        "7.....7",
        "8.....8",
        "9.....9"
    )

    private val example_3 = listOf(
        "..90..9",
        "...1.98",
        "...2..7",
        "6543456",
        "765.987",
        "876....",
        "987....",
    )

    private val example_4 = listOf(
        "10..9..",
        "2...8..",
        "3...7..",
        "4567654",
        "...8..3",
        "...9..2",
        ".....01",
    )


    private val exampleData = listOf(
        "89010123",
        "78121874",
        "87430965",
        "96549874",
        "45678903",
        "32019012",
        "01329801",
        "10456732",
    )

    @Test
    fun should_load_data() {
        // act
        val grid = Day10().loadData(Path.of("src", "test", "resources", "Day10_TestData.txt"))

        // assert
        assertThat(grid).hasSize(8)
    }

    @Test
    fun should_find_all_trailheads() {
        // arrange

        // act
        val trailheads = Day10().trailheads(exampleData)

        // assert
        assertThat(trailheads).hasSize(9)
    }

    @Test
    fun should_solve_part1_for_exampleData() {
        // act
        val sumOfScores = Day10().solvePart1(exampleData)

        // assert
        assertThat(sumOfScores).isEqualTo(36)
    }

    @Test
    fun should_return_char_from_grid_at_position() {
        // act
        val char = Day10().height(Point2D(0, 0), exampleData)

        // assert
        assertThat(char).isEqualTo(8)

    }

    @Test
    fun should_check_if_point_is_safe() {
        // arrange

        // act
        val result = Day10().isSafe(Point2D(0, 0), 7, exampleData)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_return_false_for_point_outside_of_grid() {

        // act
        val result = Day10().isSafe(Point2D(4, -1), 0, exampleData)

        // assert
        assertThat(result).isFalse()

    }

    @Test
    fun should_return_score_1_for_example_1() {
        // arrange

        // act
        val score = Day10().score(example_1, Point2D(0, 0))

        // assert
        assertThat(score).isEqualTo(1)
    }

    @Test
    fun should_return_minus_one_for_test_data() {

        // act
        val height = Day10().height(Point2D(0, 0), example_2)

        // assert
        assertThat(height).isEqualTo(-1)
    }

    @Test
    fun should_return_score_2_for_example_2() {
        // act
        val height = Day10().score(example_2, Point2D(3, 0))

        // assert
        assertThat(height).isEqualTo(2)
    }

    @Test
    fun should_return_score_4_for_example_3() {
        // act
        val height = Day10().score(example_3, Point2D(3, 0))

        // assert
        assertThat(height).isEqualTo(4)
    }

    @Test
    fun should_return_score_1_for_example_4_with_trailhead_top() {
        // act
        val height = Day10().score(example_4, Point2D(1, 0))

        // assert
        assertThat(height).isEqualTo(1)
    }

    @Test
    fun should_return_score_2_for_example_4_with_trailhead_bottom() {
        // act
        val height = Day10().score(example_4, Point2D(5, 6))

        // assert
        assertThat(height).isEqualTo(2)
    }

    @Test
    fun should_solve_part1_for_example_4() {

        // act
        val sumOfScores = Day10().solvePart1(example_4)

        // assert
        assertThat(sumOfScores).isEqualTo(3)
    }
}