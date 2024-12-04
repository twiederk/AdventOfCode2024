import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class Day04Test {

    @Test
    fun should_load_data() {

        // arrange
        val path = Path("src", "test", "resources", "Day04_TestData.txt")

        // act
        val wordPuzzle = Day04().loadData(path)

        // assert
        assertThat(wordPuzzle).hasSize(10)
    }

    @Test
    fun should_perform_bfs() {
        // arrange
        val wordPuzzle = listOf(
            "..X...",
            ".SAMX.",
            ".A..A.",
            "XMAS.S",
            ".X....",
        )

        // act
        val result = Day04().bfs(wordPuzzle)

        // assert
        assertThat(result).isEqualTo(4)
    }

    // test getLetter(x, y)
    // test getNeighbours(x, y)

}