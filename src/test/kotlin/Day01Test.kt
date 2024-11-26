import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun should_just_run() {

        // act
        val result = Day01().isResult()

        // assert
        Assertions.assertThat(result).isTrue()
    }

}