import Day09.Companion.FREE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Path

class Day09Test {

    val freeSpaceFileSystem = listOf(
        0,
        FREE, FREE,
        1, 1,
        FREE, FREE, FREE,
        2, 2, 2,
        FREE, FREE, FREE, FREE,
        3, 3, 3, 3,
    )

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

        // act
        val checksum = Day09().solvePart1("2333133121414131402")

        // assert
        assertThat(checksum).isEqualTo(1928)
    }

    @Test
    fun should_find_free_space_with_size_1() {

        // act
        val freeSpace = Day09().freeSpace(freeSpaceFileSystem, 1, freeSpaceFileSystem.size)

        // assert
        assertThat(freeSpace).isEqualTo(1)
    }

    @Test
    fun should_find_free_space_with_size_2() {

        // act
        val freeSpace = Day09().freeSpace(freeSpaceFileSystem, 2, freeSpaceFileSystem.size)

        // assert
        assertThat(freeSpace).isEqualTo(1)
    }

    @Test
    fun should_find_free_space_with_size_3() {

        // act
        val freeSpace = Day09().freeSpace(freeSpaceFileSystem, 3, freeSpaceFileSystem.size)

        // assert
        assertThat(freeSpace).isEqualTo(5)
    }

    @Test
    fun should_find_free_space_with_size_4() {

        // act
        val freeSpace = Day09().freeSpace(freeSpaceFileSystem, 4, freeSpaceFileSystem.size)

        // assert
        assertThat(freeSpace).isEqualTo(11)
    }

    @Test
    fun should_find_free_space_with_size_5() {

        // act
        val freeSpace = Day09().freeSpace(freeSpaceFileSystem, 5, freeSpaceFileSystem.size)

        // assert
        assertThat(freeSpace).isEqualTo(Day09.NO_FREE_SPACE)
    }

    @Test
    fun should_find_file_size() {

        // act
        val fileSize = Day09().fileSize(freeSpaceFileSystem, freeSpaceFileSystem.size - 1)

        // assert
        assertThat(fileSize).isEqualTo(4)
    }

}


