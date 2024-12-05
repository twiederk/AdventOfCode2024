import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day05Test {

    @Test
    fun should_check_if_75_is_in_the_right_place() {
        // arrange
        val rules = mapOf(
            75 to listOf(29, 53, 47, 61, 13)
        )
        val update = listOf(47, 61, 53, 29)

        // act
        val result = Day05().validatePageOrder(75, rules, update)

        // assert
        assertThat(result).isTrue()
    }
}