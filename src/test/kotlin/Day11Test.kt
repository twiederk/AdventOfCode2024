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

}