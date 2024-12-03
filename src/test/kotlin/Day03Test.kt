import org.junit.jupiter.api.Test

class Day03Test {

    @Test
    fun should_use_RegEx_to_find_matches() {
        // arrange
        val input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
//        val regex = Regex("""mul(\\d1-3,\\d1-3)""")
        val regex = Regex("""mul\(\d{1,3},\d{1,3}\)""")


        // act
        val matches = regex.findAll(input)
        for (match in matches) {
            val firstDigit = match.value.substringAfter("mul(").substringBefore(",")
            println(firstDigit)
            val secondDigit = match.value.substringAfter(",").substringBefore(")")
            println(secondDigit)
            println("match.value = ${match.value}")
//            val (firstDigit, secondDigit) = match.destructured
//            println("Found match: mul($firstDigit, $secondDigit)")
        }

        // assert

    }

    /*
        val input = "mul(2, 3) and mul(4, 5) are examples"
    val regex = Regex("""mul\((\d+),\s*(\d+)\)""")

    val matches = regex.findAll(input)
    for (match in matches) {
        val (firstDigit, secondDigit) = match.destructured
        println("Found match: mul($firstDigit, $secondDigit)")
    }
     */
}