import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day09Test {

    @Test
    fun should_calculate_checksum() {

        // act
        val checksum = Day09().checksum("0099811188827773336446555566..............")

        // assert
        assertThat(checksum).isEqualTo(1928)
    }
}

