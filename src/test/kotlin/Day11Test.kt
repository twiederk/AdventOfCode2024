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

}