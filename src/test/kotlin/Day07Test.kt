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

}