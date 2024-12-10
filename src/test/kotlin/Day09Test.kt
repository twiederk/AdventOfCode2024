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
}


