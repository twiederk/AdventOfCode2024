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
    fun should_calculate_checksum() {

        // act
        val checksum = Day09().checksum("0099811188827773336446555566..............")

        // assert
        assertThat(checksum).isEqualTo(1928)
    }

}


