import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class Day04Test {

    private val wordPuzzle = listOf(
        "..X...",
        ".SAMX.",
        ".A..A.",
        "XMAS.S",
        ".X....",
    )

    @Test
    fun should_load_data() {

        // arrange
        val path = Path("src", "test", "resources", "Day04_TestData.txt")

        // act
        val wordPuzzle = Day04().loadData(path)

        // assert
        assertThat(wordPuzzle).hasSize(10)
    }

    @Test
    fun should_return_letter_at_position() {

        // act
        val result = Day04().letter(Point2D(2, 0), wordPuzzle)

        // assert
        assertThat(result).isEqualTo('X')
    }

    @Test
    fun should_return_minus_sign_when_letter_not_on_grid() {

        // act
        var result = Day04().letter(Point2D(-1, -1), wordPuzzle)

        // assert
        assertThat(result).isEqualTo('-')

    }

    @Test
    fun should_return_list_of_neighbors_at_2_0() {

        // act
        val neighbors = Day04().neighbours(Point2D(2, 0), wordPuzzle)

        // assert
        assertThat(neighbors).containsExactly(Point2D(3, 1))
    }

    @Test
    fun should_return_starting_points() {

        // act
        val startingPoints = Day04().startingPoints(wordPuzzle, 'X')

        // assert
        assertThat(startingPoints).hasSize(4)
    }

    @Test
    fun should_return_true_when_horizontal_left_to_right_word() {

        // act
        val result = Day04().word(Point2D(0, 3), Point2D.EAST, wordPuzzle)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_return_true_when_starting_points_is_0_0() {

        // act
        val result = Day04().word(Point2D(0, 0), Point2D.EAST, wordPuzzle)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_check_all_directions_of_starting_point() {

        // act
        val result = Day04().numberOfWords(Point2D(2, 0), wordPuzzle)

        // assert
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun should_solve_simple_puzzle() {

        // act
        val result = Day04().solvePart1(wordPuzzle)

        // assert
        assertThat(result).isEqualTo(4)

    }

    @Test
    fun should_solve_test_puzzle() {
        // arrange
        val testPuzzle = listOf(
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX",
        )

        // act
        val result = Day04().solvePart1(testPuzzle)

        // assert
        assertThat(result).isEqualTo(18)
    }

}




