import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day12Test {

    @Test
    fun should_load_data() {

        // act
        val garden = Day12().loadData(Path.of("src", "test", "resources", "Day12_TestData.txt"))

        // assert
        assertThat(garden).hasSize(10)
    }

}