import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class Day07Test {

    @Test
    fun should_load_data() {
        // act
        val equations = Day07().loadData(Path("src", "test", "resources", "Day07_TestData.txt"))

        // assert
        assertThat(equations).hasSize(9)
        assertThat(equations[0]).isEqualTo(Equation(190, listOf(10, 19)))
        assertThat(equations[1]).isEqualTo(Equation(3267, listOf(81, 40, 27)))
        assertThat(equations[7]).isEqualTo(Equation(21037, listOf(9, 7, 18, 13)))
    }

    @Test
    fun should_check_equation_190_with_plus_operand() {
        // arrange
        val equation = Equation(190, listOf(10, 19))
        val operators = listOf("+")

        // act
        val result = Day06().evaluate(equation, operators)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_check_equation_190_with_multiply_operand() {
        // arrange
        val equation = Equation(190, listOf(10, 19))
        val operators = listOf("*")

        // act
        val result = Day06().evaluate(equation, operators)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_check_equation_3267_with_plus_plus_operand() {
        // arrange
        val equation = Equation(3267, listOf(81, 40, 27))
        val operators = listOf("+", "+")

        // act
        val result = Day06().evaluate(equation, operators)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_check_equation_3267_with_plus_multiply_operand() {
        // arrange
        val equation = Equation(3267, listOf(81, 40, 27))
        val operators = listOf("+", "*")

        // act
        val result = Day06().evaluate(equation, operators)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_check_equation_3267_with_multiply_plus_operand() {
        // arrange
        val equation = Equation(3267, listOf(81, 40, 27))
        val operators = listOf("*", "+")

        // act
        val result = Day06().evaluate(equation, operators)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_check_equation_3267_with_multiply_multiply_operand() {
        // arrange
        val equation = Equation(3267, listOf(81, 40, 27))
        val operators = listOf("*", "*")

        // act
        val result = Day06().evaluate(equation, operators)

        // assert
        assertThat(result).isFalse()
    }
}