import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day08Test {

    @Test
    fun should_load_data() {
        // arrange

        // act
        val grid = Day08().loadData(Path.of("src", "test", "resources", "Day08_TestData.txt"))

        // assert
        assertThat(grid).hasSize(12)
    }

}