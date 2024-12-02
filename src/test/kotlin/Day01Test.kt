import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class Day01Test {

    @Test
    fun should_load_data_in_two_lists() {

        // arrange
        val path = Path("src", "test", "resources", "Day01_TestData.txt")

        // act
        val result = Day01().loadData(path)

        // assert
        assertThat(result.first).containsExactly(3, 4, 2, 1, 3, 3)
        assertThat(result.second).containsExactly(4, 3, 5, 3, 9, 3)
    }

    @Test
    fun should_sort_both_lists() {
        // arrange
        val first = listOf(3, 4, 2, 1, 3, 3)
        val second = listOf(4, 3, 5, 3, 9, 3)

        // act
        val result = Day01().sortData(first, second)

        // assert
        assertThat(result.first).containsExactly(1, 2, 3, 3, 3, 4)
        assertThat(result.second).containsExactly(3, 3, 3, 4, 5, 9)
    }

    @Test
    fun should_calc_distance_between_both_values_first_value_lower() {
        // arrange

        // act
        val result = Day01().calcDistance(1, 3)

        // assert
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun should_calc_distance_between_both_values_second_value_lower() {

        // act
        val result = Day01().calcDistance(3, 1)

        // assert
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun should_sum_up_total_distance() {
        // arrange
        val first = listOf(1, 2, 3, 3, 3, 4)
        val second = listOf(3, 3, 3, 4, 5, 9)

        // act
        val result = Day01().sumUpDistance(first, second)

        // assert
        assertThat(result).isEqualTo(11)
    }

    @Test
    fun should_solve_part1() {
        // arrange
        val first = listOf(3, 4, 2, 1, 3, 3)
        val second = listOf(4, 3, 5, 3, 9, 3)

        // act
        val result = Day01().part1(first, second)

        // assert
        assertThat(result).isEqualTo(11)
    }

    @Test
    fun should_return_count_of_number_in_list() {
        // arrange
        val second = listOf(4, 3, 5, 3, 9, 3)

        // act
        val result = Day01().countNumberInList(second, 3)

        // assert
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun should_multiply_number_with_count_of_number_in_list_3() {
        // arrange
        val second = listOf(4, 3, 5, 3, 9, 3)

        // act
        val result = Day01().multiplyNumberWithCountOfNumberInList(second, 3)

        // assert
        assertThat(result).isEqualTo(9)
    }

    @Test
    fun should_multiply_number_with_count_of_number_in_list_1() {
        // arrange
        val second = listOf(4, 3, 5, 3, 9, 3)

        // act
        val result = Day01().multiplyNumberWithCountOfNumberInList(second, 1)

        // assert
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun should_solve_part2() {
        // arrange
        val first = listOf(3, 4, 2, 1, 3, 3)
        val second = listOf(4, 3, 5, 3, 9, 3)

        // act
        val result = Day01().part2(first, second)

        // assert
        assertThat(result).isEqualTo(31)
    }

}