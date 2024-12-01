import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class Day01Test {

    @Test
    fun should_load_data_in_two_lists() {

        // arrange
        val path = Path("src", "test", "resources", "Day01_TestData.txt")

        // act
        val result = Day01().loadData(path)

        // assert
        assertThat(result.first).containsExactly(3, 4, 2, 1, 3, 3)
        assertThat(result.second).containsExactly(4, 3, 5, 3, 9, 3)
    }

}