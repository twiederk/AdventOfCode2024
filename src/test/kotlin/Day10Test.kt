import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day10Test {

    @Test
    fun should_load_data() {
        // act
        val grid = Day10().loadData(Path.of("src", "test", "resources", "Day10_TestData.txt"))

        // assert
        assertThat(grid).hasSize(8)
    }

}