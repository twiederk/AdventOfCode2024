import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class Day02Test {

    @Test
    fun should_load_data() {

        // arrange
        val path = Path("src", "test", "resources", "Day02_TestData.txt")

        // act
        val reports = Day02().loadData(path)

        // assert
        assertThat(reports).hasSize(6)
    }

    @Test
    fun should_decrease_with_every_window_in_the_list() {
        // arrange
        val report = listOf(7, 6, 4, 2, 1)

        // act
        val result = Day02().diffs(report)

        // assert
        assertThat(result).containsExactly(-1, -2, -2, -1)
    }

    @Test
    fun should_return_true_when_decreasing_is_valid() {
        // arrange
        val diffs = listOf(-1, -2, -2, -1)

        // act
        val result = Day02().validDecrease(diffs)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_return_true_when_increasing_is_valid() {
        // arrange
        val diffs = listOf(1, 2, 2, 1)

        // act
        val result = Day02().validIncrease(diffs)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_return_true_when_report_is_valid() {
        // arrange
        val report = listOf(7, 6, 4, 2, 1)

        // act
        val result = Day02().validReport(report)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_return_false_when_report_is_invalid() {
        // arrange
        val report = listOf(1, 2, 7, 8, 9)

        // act
        val result = Day02().validReport(report)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_solve_part1() {
        // arrange
        val input = listOf(
            listOf(7, 6, 4, 2, 1),
            listOf(1, 2, 7, 8, 9),
            listOf(9, 7, 6, 2, 1),
            listOf(1, 3, 2, 4, 5),
            listOf(8, 6, 4, 4, 1),
            listOf(1, 3, 6, 7, 9),
        )

        // act
        val result = Day02().part1(input)

        // assert
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun should_return_true_when_skipping_one_element_by_increasing() {
        // arrange
        val diffs = listOf(2, -1, 2, 1)

        // act
        var result = Day02().validDampenerIncrease(diffs)

        // assert
        assertThat(result).isTrue
    }

    @Test
    fun should_return_true_when_skipping_one_element_by_decreasing() {
        // arrange
        val diffs = Day02().diffs(listOf(8, 6, 4, 4, 1))

        // act
        var result = Day02().validDampenerDecrease(diffs)

        // assert
        assertThat(result).isTrue
    }

    @Test
    fun should_return_true_when_report_is_dampener_valid() {
        // arrange
        val report = listOf(1, 3, 2, 4, 5)

        // act
        val result = Day02().validDampenerReport(report)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_return_false_when_report_is_dampener_invalid() {
        // arrange
        val report = listOf(9, 7, 6, 2, 1)

        // act
        val result = Day02().validDampenerReport(report)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_return_false_when_diff_is_dampener_decrease_invalid() {
        // arrange
        val diffs = Day02().diffs(listOf(9, 7, 6, 2, 1))
        println(diffs)

        // act
        val result = Day02().validDampenerDecrease(diffs)

        // assert
        assertThat(result).isFalse()

    }
}




