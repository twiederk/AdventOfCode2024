import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class Day05Test {

    @Test
    fun should_load_rules() {
        // arrange
        val path = Path("src", "test", "resources", "Day05_TestData.txt")

        // act
        val (rules, updates) = Day05().loadRules(path)

        // assert
        assertThat(rules[75]).containsExactly(29, 53, 47, 61, 13)
        assertThat(updates).hasSize(6)
    }

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