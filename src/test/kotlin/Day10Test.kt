import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day10Test {

    private val exampleData = listOf(
        "89010123",
        "78121874",
        "87430965",
        "96549874",
        "45678903",
        "32019012",
        "01329801",
        "10456732",
    )

    @Test
    fun should_load_data() {
        // act
        val grid = Day10().loadData(Path.of("src", "test", "resources", "Day10_TestData.txt"))

        // assert
        assertThat(grid).hasSize(8)
    }

    @Test
    fun should_find_all_trailheads() {
        // arrange

        // act
        val trailheads = Day10().trailheads(exampleData)

        // assert
        assertThat(trailheads).hasSize(9)

    }
}