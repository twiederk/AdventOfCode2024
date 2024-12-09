import Day09.Companion.FREE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day09Test {

    @Test
    fun should_load_data() {

        // act
        val data = Day09().loadData(Path.of("src", "test", "resources", "Day09_TestData.txt"))

        // assert
        assertThat(data).isEqualTo("2333133121414131402")
    }

    @Test
    fun should_convert_disk_map_123_to_filesystem() {

        // act
        val filesystem = Day09().filesystem("123")

        // assert
        assertThat(filesystem).containsExactly(0, FREE, FREE, 1, 1, 1)
    }

    @Test
    fun should_convert_disk_map_12345_to_filesystem() {

        // act
        val filesystem = Day09().filesystem("12345")

        // assert
        assertThat(filesystem).containsExactly(0, FREE, FREE, 1, 1, 1, FREE, FREE, FREE, FREE, 2, 2, 2, 2, 2)
    }

    @Test
    fun should_convert_disk_map_2333133121414131402_to_filesystem() {

        // act
        val filesystem = Day09().filesystem("2333133121414131402")

        // assert
        assertThat(filesystem).containsExactly(
            0, 0,
            FREE, FREE, FREE,
            1, 1, 1,
            FREE, FREE, FREE,
            2,
            FREE, FREE, FREE,
            3, 3, 3,
            FREE,
            4, 4,
            FREE,
            5, 5, 5, 5,
            FREE,
            6, 6, 6, 6,
            FREE,
            7, 7, 7,
            FREE,
            8, 8, 8, 8,
            9, 9
        )
    }

    @Test
    fun should_fragment_simple_filesystem() {
        // arrange
        val filesystem = mutableListOf(
            0, FREE, FREE, 1
        )

        // act
        val newFilesystem = Day09().fragmenter(filesystem)

        // assert
        assertThat(newFilesystem).containsExactly(
            0, 1, FREE, FREE
        )
    }

    @Test
    fun should_fragment_example() {
        // arrange
        val filesystem = mutableListOf(
            0, 0,
            FREE, FREE, FREE,
            1, 1, 1,
            FREE, FREE, FREE,
            2,
            FREE, FREE, FREE,
            3, 3, 3,
            FREE,
            4, 4,
            FREE,
            5, 5, 5, 5,
            FREE,
            6, 6, 6, 6,
            FREE,
            7, 7, 7,
            FREE,
            8, 8, 8, 8,
            9, 9
        )

        // act
        val newFilesystem = Day09().fragmenter(filesystem)

        // assert
        assertThat(newFilesystem).containsExactly(
            0, 0, 9, 9, 8, 1, 1, 1, 8, 8, 8, 2, 7, 7, 7, 3, 3, 3, 6, 4, 4, 6, 5, 5, 5, 5, 6, 6,
            FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE
        )
    }

    @Test
    fun should_calculate_checksum() {

        // arrange
        val filesystem = listOf(
            0, 0, 9, 9, 8, 1, 1, 1, 8, 8, 8, 2, 7, 7, 7, 3, 3, 3, 6, 4, 4, 6, 5, 5, 5, 5, 6, 6,
            FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE
        )

        // act
        val checksum = Day09().checksum(filesystem)

        // assert
        assertThat(checksum).isEqualTo(1928)
    }

    @Test
    fun should_solve_part1() {
        // arrange

        // act
        val checksum = Day09().solvePart1("2333133121414131402")

        // assert
        assertThat(checksum).isEqualTo(1928)

    }
}


