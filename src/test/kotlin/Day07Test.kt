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
        val result = Day07().evaluate(equation, operators)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_check_equation_190_with_multiply_operand() {
        // arrange
        val equation = Equation(190, listOf(10, 19))
        val operators = listOf("*")

        // act
        val result = Day07().evaluate(equation, operators)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_check_equation_3267_with_plus_plus_operand() {
        // arrange
        val equation = Equation(3267, listOf(81, 40, 27))
        val operators = listOf("+", "+")

        // act
        val result = Day07().evaluate(equation, operators)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_check_equation_3267_with_plus_multiply_operand() {
        // arrange
        val equation = Equation(3267, listOf(81, 40, 27))
        val operators = listOf("+", "*")

        // act
        val result = Day07().evaluate(equation, operators)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_check_equation_3267_with_multiply_plus_operand() {
        // arrange
        val equation = Equation(3267, listOf(81, 40, 27))
        val operators = listOf("*", "+")

        // act
        val result = Day07().evaluate(equation, operators)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_check_equation_3267_with_multiply_multiply_operand() {
        // arrange
        val equation = Equation(3267, listOf(81, 40, 27))
        val operators = listOf("*", "*")

        // act
        val result = Day07().evaluate(equation, operators)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_generate_all_permutations_for_2_operands() {

        // act
        val permutations = Day07().generateAllPermutations(2)

        // assert
        assertThat(permutations).hasSize(4)
    }

    @Test
    fun should_generate_all_permutations_for_3_operands() {

        // act
        val permutations = Day07().generateAllPermutations(3)

        // assert
        assertThat(permutations).hasSize(8)
    }

    @Test
    fun should_generate_all_permutations_for_4_operands() {

        // act
        val permutations = Day07().generateAllPermutations(4)

        // assert
        assertThat(permutations).hasSize(16)
    }

    @Test
    fun should_check_equation_190_will_all_permuations() {

        // act
        val result = Day07().checkEquationWithAllPermutations(Equation(190, listOf(10, 19)))

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_check_equation_3267_will_all_permuations() {

        // act
        val result = Day07().checkEquationWithAllPermutations(Equation(3267, listOf(81, 40, 27)))

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_check_equation_21037_will_all_permuations() {

        // act
        val result = Day07().checkEquationWithAllPermutations(Equation(21037, listOf(9, 7, 18, 13)))

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_solve_part1() {
        // arrange
        val equations = Day07().loadData(Path("src", "test", "resources", "Day07_TestData.txt"))

        // act
        val result = Day07().solvePart1(equations)

        // assert
        assertThat(result).isEqualTo(3749)
    }

    @Test
    fun should_check_equation_156_with_concat() {

        // act
        val result = Day07().evaluate(Equation(156, listOf(15, 6)), listOf("|"))

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_check_equation_7290_with_multiply_concat_multiply() {

        // act
        val result = Day07().evaluate(Equation(7290, listOf(6, 8, 6, 15)), listOf("*", "|", "*"))

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_check_equation_192_with_concat_plus() {
        // act
        val result = Day07().evaluate(Equation(192, listOf(17, 8, 14)), listOf("|", "+"))

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_convert_0_to_permutation() {

        // act
        val permutation = Day07().convertIntToPermutation(0)

        // assert
        assertThat(permutation).isEqualTo(listOf("+"))
    }

    @Test
    fun should_convert_1_to_permutation() {

        // act
        val permutation = Day07().convertIntToPermutation(1)

        // assert
        assertThat(permutation).isEqualTo(listOf("*"))
    }

    @Test
    fun should_convert_2_to_permutation() {

        // act
        val permutation = Day07().convertIntToPermutation(2)

        // assert
        assertThat(permutation).isEqualTo(listOf("*", "+"))
    }

    @Test
    fun should_convert_3_to_permutation() {

        // act
        val permutation = Day07().convertIntToPermutation(3)

        // assert
        assertThat(permutation).isEqualTo(listOf("*", "*"))
    }

    @Test
    fun should_convert_16_to_permutation() {

        // act
        val permutation = Day07().convertIntToPermutation(16)

        // assert
        assertThat(permutation).isEqualTo(listOf("*", "+", "+", "+", "+"))
    }

}