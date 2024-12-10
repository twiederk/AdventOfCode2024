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

    private val example1 = listOf(
        "..........",
        "...#......",
        "..........",
        "....a.....",
        "..........",
        ".....a....",
        "..........",
        "......#...",
        "..........",
        "..........",
    )

    private val example2 = listOf(
        "..........",
        "...#......",
        "#.........",
        "....a.....",
        "........a.",
        ".....a....",
        "..#.......",
        "......#...",
        "..........",
        "..........",
    )

    private val example3 = listOf(
        "T....#....",
        "...T......",
        ".T....#...",
        ".........#",
        "..#.......",
        "..........",
        "...#......",
        "..........",
        "....#.....",
        "..........",
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

        // act
        val antennas = Day08().antennas(example)

        // assert
        assertThat(antennas).hasSize(2)
        assertThat(antennas['0']).hasSize(4)
        assertThat(antennas['A']).hasSize(3)
    }

    @Test
    fun should_generate_antinodes_for_example1() {
        // arrange
        val antennas = listOf(
            Point2D(4, 3),
            Point2D(5, 5),
        )

        // act
        val antinodes = Day08().antinodes(antennas, example1)

        // assert
        assertThat(antinodes).containsExactly(
            Point2D(3, 1),
            Point2D(6, 7)
        )
    }

    @Test
    fun should_generate_antinodes_for_example2() {
        // arrange
        val antennas = listOf(
            Point2D(4, 3),
            Point2D(8, 4),
            Point2D(5, 5),
        )

        // act
        val antinodes = Day08().antinodes(antennas, example2)

        // assert
        assertThat(antinodes).containsExactly(
            Point2D(0, 2),
            Point2D(3, 1),
            Point2D(6, 7),
            Point2D(2, 6)
        )
    }

    @Test
    fun should_solve_part1() {

        // act
        val result = Day08().solvePart1(example)

        // assert
        assertThat(result).isEqualTo(14)

    }

    @Test
    fun should_generate_antinodes_for_example3() {
        // arrange
        val antennas = listOf(
            Point2D(0, 0),
            Point2D(3, 1),
            Point2D(1, 2),
        )

        // act
        val antinodes = Day08().antinodesResonantHarmonics(antennas, example3)

        // assert
        assertThat(antinodes).containsExactly(
            Point2D(6, 2),
            Point2D(9, 3),
            Point2D(5, 0),
            Point2D(2, 4),
            Point2D(3, 6),
            Point2D(4, 8),
        )
    }

    @Test
    fun should_solve_part2() {
        // act
        val result = Day08().solvePart2(example)

        // assert
        assertThat(result).isEqualTo(34)
    }

}