import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day08Test {

    private val example = listOf(
        "............",
        "........0...",
        ".....0......",
        ".......0....",
        "....0.......",
        "......A.....",
        "............",
        "............",
        "........A...",
        ".........A..",
        "............",
        "............",
    )

    @Test
    fun should_load_data() {
        // arrange

        // act
        val grid = Day08().loadData(Path.of("src", "test", "resources", "Day08_TestData.txt"))

        // assert
        assertThat(grid).hasSize(12)
    }

    @Test
    fun should_find_all_antennas() {
        // arrange

        // act
        val antennas = Day08().antennas(example)

        // assert
        assertThat(antennas).hasSize(2)
        assertThat(antennas['0']).hasSize(4)
        assertThat(antennas['A']).hasSize(3)

    }
}