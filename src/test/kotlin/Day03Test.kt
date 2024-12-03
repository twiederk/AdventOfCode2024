import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class Day03Test {

    @Test
    fun should_load_data() {
        // arrange
        val path = Path("src", "test", "resources", "Day03_TestData.txt")

        // arrange
        val memory = Day03().loadData(path)

        // assert
        assertThat(memory).containsExactly("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")

    }

    @Test
    fun should_use_RegEx_to_find_matches() {
        // arrange
        val input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"

        // act
        val multiplicators = Day03().findMultiplicators(input)

        // assert
        assertThat(multiplicators.count()).isEqualTo(4)
    }

    @Test
    fun should_sum_up_the_products_of_the_multiplicators() {
        // arrange
        val multiplicators = listOf(Pair(2, 4), Pair(5, 5), Pair(11, 8), Pair(8, 5))

        // act
        val sum = Day03().sumUpMultiplicators(multiplicators)

        // assert
        assertThat(sum).isEqualTo(161)
    }

    @Test
    fun should_solve_part1() {
        // arrange
        val memory = listOf("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")

        // act
        val result = Day03().solvePart1(memory)

        // assert
        assertThat(result).isEqualTo(161)

    }
}

