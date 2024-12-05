import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class Day05Test {

    private val exampleRules = mapOf(
        47 to listOf(53, 13, 61, 29),
        97 to listOf(13, 61, 47, 29, 53, 75),
        75 to listOf(29, 53, 47, 61, 13),
        61 to listOf(13, 53, 29),
        29 to listOf(13),
        53 to listOf(29, 13)
    )

    private val exampleUpdates = listOf(
        listOf(75, 47, 61, 53, 29),
        listOf(97, 61, 53, 29, 13),
        listOf(75, 29, 13),
        listOf(75, 97, 47, 61, 53),
        listOf(61, 13, 29),
        listOf(97, 13, 75, 29, 47),
    )

    @Test
    fun should_load_rules() {
        // arrange
        val path = Path("src", "test", "resources", "Day05_TestData.txt")

        // act
        val (rules, updates) = Day05().loadRules(path)

        // assert
        println(rules)
        assertThat(rules[75]).containsExactly(29, 53, 47, 61, 13)
        assertThat(updates).hasSize(6)
    }

    @Test
    fun should_validate_next_number() {
        // arrange
        val update = listOf(75, 47, 61, 53, 29)

        // act
        val result = Day05().validateNextStep(75, 47, exampleRules)

        // assert
        assertThat(result).isTrue()

    }

    @Test
    fun should_validate_update_75_29_53_47_61_13() {
        // arrange
        val update = listOf(75, 47, 61, 53, 29)

        // act
        val result = Day05().validateUpdate(update, exampleRules)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_validate_update_75_29_13() {
        // arrange
        val update = listOf(75, 29, 13)

        // act
        val result = Day05().validateUpdate(update, exampleRules)

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun should_validate_update_to_false() {
        // arrange
        val update = listOf(97, 13, 75, 29, 47)

        // act
        val result = Day05().validateUpdate(update, exampleRules)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun should_validate_example_data() {

        // act
        val validUpdates = Day05().validateUpdates(exampleUpdates, exampleRules)

        // assert
        assertThat(validUpdates).containsExactly(
            listOf(75, 47, 61, 53, 29),
            listOf(97, 61, 53, 29, 13),
            listOf(75, 29, 13),
        )
    }

    @Test
    fun should_calculate_final_score() {
        // arrange
        val validUpdates = listOf(
            listOf(75, 47, 61, 53, 29),
            listOf(97, 61, 53, 29, 13),
            listOf(75, 29, 13),
        )

        // act
        val result = Day05().calculateFinalScore(validUpdates)

        // assert
        assertThat(result).isEqualTo(143)
    }

    @Test
    fun should_solve_part1() {

        // act
        val result = Day05().solvePart1(exampleRules, exampleUpdates)

        // assert
        assertThat(result).isEqualTo(143)
    }

    @Test
    fun should_return_index_of_broken_path() {
        // arrange
        val update = listOf(97, 13, 75, 29, 47)

        // act
        val index = Day05().findBrokenIndex(update, exampleRules)

        // assert
        assertThat(index).isEqualTo(1)
    }

    @Test
    fun should_switch_elements_at_given_index() {
        // arrange
        val update = listOf(97, 13, 75, 29, 47)

        // act
        val result = Day05().switchElements(update, 1)

        // assert
        assertThat(result).containsExactly(97, 75, 13, 29, 47)
    }

    @Test
    fun should_correct_broken_update() {
        // arrange
        val update = listOf(97, 13, 75, 29, 47)

        // act
        val result = Day05().correctBrokenUpdate(update, exampleRules)

        // assert
        assertThat(result).containsExactly(97, 75, 47, 29, 13)
    }

    @Test
    fun should_solve_part2() {
        // act
        val result = Day05().solvePart2(exampleRules, exampleUpdates)

        // assert
        assertThat(result).isEqualTo(123)
    }

}