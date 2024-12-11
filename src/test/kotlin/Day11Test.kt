import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day11Test {

    @Test
    fun should_load_data() {

        // act
        val data = Day11().loadData(Path.of("src", "test", "resources", "Day11_TestData.txt"))

        // assert
        assertThat(data).containsExactly(125L, 17L)
    }

    @Test
    fun should_return_true_when_Rule1_is_usable() {
        // act
        val result = Day11.Rule1().usable(0L)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_return_false_when_Rule1_is_not_usable() {
        // act
        val result = Day11.Rule1().usable(1L)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_execute_Rule1() {

        // act
        val stones = Day11.Rule1().execute(0L)

        // assert
        assertThat(stones).containsExactly(1L)
    }

    @Test
    fun should_return_true_when_Rule2_is_usable() {
        // act
        val result = Day11.Rule2().usable(1000L)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_return_false_when_Rule2_is_not_usable() {
        // act
        val result = Day11.Rule2().usable(100L)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_execute_Rule2() {

        // act
        val stones = Day11.Rule2().execute(1000L)

        // assert
        assertThat(stones).containsExactly(10L, 0L)
    }

    @Test
    fun should_return_true_when_Rule3_is_usable() {
        // act
        val result = Day11.Rule3().usable(100L)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_execute_Rule3_with_value1() {

        // act
        val stones = Day11.Rule3().execute(1L)

        // assert
        assertThat(stones).containsExactly(2024L)
    }

    @Test
    fun should_execute_Rule3_with_value2() {

        // act
        val stones = Day11.Rule3().execute(2L)

        // assert
        assertThat(stones).containsExactly(4048L)
    }

    @Test
    fun should_execute_Rule1_from_rules() {
        // arrange
        val rules = listOf(Day11.Rule1(), Day11.Rule2(), Day11.Rule3())

        // act
        val stones = Day11().executeRules(0L, rules)

        // assert
        assertThat(stones).containsExactly(1L)
    }

    @Test
    fun should_execute_Rule3_from_rules() {
        // arrange
        val rules = listOf(Day11.Rule1(), Day11.Rule2(), Day11.Rule3())

        // act
        val stones = Day11().executeRules(1L, rules)

        // assert
        assertThat(stones).containsExactly(2024L)
    }

    @Test
    fun should_execute_Rule2_from_rules() {
        // arrange
        val rules = listOf(Day11.Rule1(), Day11.Rule2(), Day11.Rule3())

        // act
        val stones = Day11().executeRules(10L, rules)

        // assert
        assertThat(stones).containsExactly(1L, 0L)
    }

    @Test
    fun should_blink_once_with_simple_example() {
        // arrange
        val rules = listOf(Day11.Rule1(), Day11.Rule2(), Day11.Rule3())
        val stones = listOf(0L, 1L, 10L, 99L, 999L)

        // act
        val newStones = Day11().blink(stones, rules)

        // assert
        assertThat(newStones).containsExactly(1L, 2024L, 1L, 0L, 9L, 9L, 2021976L)
    }

    @Test
    fun should_blink_6_times_with_test_data() {
        // arrange
        val rules = listOf(Day11.Rule1(), Day11.Rule2(), Day11.Rule3())
        val stones = listOf(125L, 17L)

        // act
        val newStones = Day11().blinking(stones, rules, 6)

        // assert
        assertThat(newStones).containsExactly(
            2097446912L,
            14168L,
            4048L,
            2L,
            0L,
            2L,
            4L,
            40L,
            48L,
            2024L,
            40L,
            48L,
            80L,
            96L,
            2L,
            8L,
            6L,
            7L,
            6L,
            0L,
            3L,
            2L
        )

    }
}

