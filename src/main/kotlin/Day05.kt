import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.name

class Day05 {

    fun loadRules(path: Path): Pair<Map<Int, MutableList<Int>>, List<List<Int>>> {
        val data = Resources.resourceAsListOfString(path.name)
        val emptyLineIndex = data.indexOfFirst { it.isEmpty() }

        val rules = rules(data, emptyLineIndex)
        val updates: List<List<Int>> = data.subList(emptyLineIndex + 1, data.size)
            .map { input -> input.split(",").map { it.toInt() } }
        return Pair(rules, updates)

    }

    private fun rules(data: List<String>, emptyLine: Int): MutableMap<Int, MutableList<Int>> {
        val rules = mutableMapOf<Int, MutableList<Int>>()
        val ruleData = data.subList(0, emptyLine)
        ruleData.forEach {
            val (page1, page2) = it.split("|")
            val pages = rules.getOrDefault(page1.toInt(), mutableListOf())
            pages.add(page2.toInt())
            rules.put(page1.toInt(), pages)
        }
        return rules
    }

    fun validateUpdate(update: List<Int>, rules: Map<Int, List<Int>>): Boolean {
        var remainingUpdate = update
        while (remainingUpdate.size > 1) {
            val currentPage = remainingUpdate[0]
            remainingUpdate = remainingUpdate.drop(1)
            if (!validateNextStep(currentPage, remainingUpdate[0], rules)) {
                return false
            }
        }
        return true
    }

    fun validateUpdates(updates: List<List<Int>>, rules: Map<Int, List<Int>>): List<List<Int>> {
        return updates.filter { validateUpdate(it, rules) }
    }

    fun invalidateUpdates(updates: List<List<Int>>, rules: Map<Int, List<Int>>): List<List<Int>> {
        return updates.filter { !validateUpdate(it, rules) }
    }


    fun validateNextStep(currentPage: Int, nextPage: Int, rules: Map<Int, List<Int>>): Boolean {
        val pageRules = rules[currentPage] ?: return false
        return pageRules.contains(nextPage)
    }

    fun calculateFinalScore(validUpdates: List<List<Int>>): Int {
        val middleElements = validUpdates.map { it[it.size / 2] }
        return middleElements.sum()
    }

    fun solvePart1(rules: Map<Int, List<Int>>, updates: List<List<Int>>): Int {
        val validUpdates = validateUpdates(updates, rules)
        return calculateFinalScore(validUpdates)
    }

    fun findBrokenIndex(update: List<Int>, rules: Map<Int, List<Int>>): Int {
        update.windowed(2, 1).forEachIndexed { index, pair ->
            if (!validateNextStep(pair[0], pair[1], rules)) {
                return index
            }
        }
        return -1
    }

    fun switchElements(update: List<Int>, index: Int): List<Int> {
        val first = update[index]
        val second = update[index + 1]
        val newUpdate = update.toMutableList()
        newUpdate[index] = second
        newUpdate[index + 1] = first
        return newUpdate
    }

    fun correctBrokenUpdate(update: List<Int>, rules: Map<Int, List<Int>>): List<Int> {
        var index = findBrokenIndex(update, rules)
        var newUpdate = update
        while (index != -1) {
            newUpdate = switchElements(newUpdate, index)
            if (validateUpdate(newUpdate, rules)) {
                return newUpdate
            }
            index = findBrokenIndex(newUpdate, rules)
        }
        return throw IllegalArgumentException("No valid update found")
    }

    fun solvePart2(rules: Map<Int, List<Int>>, updates: List<List<Int>>): Int {
        val invalidUpdates = invalidateUpdates(updates, rules)
        val validUpdates = invalidUpdates.map { correctBrokenUpdate(it, rules) }
        return calculateFinalScore(validUpdates)
    }

}

fun main() {
    val day05 = Day05()
    val (rules, updates) = day05.loadRules(Path("src", "main", "resources", "Day05_InputData.txt"))
    println("Part 1: ${day05.solvePart1(rules, updates)}")
    println("Part 2: ${day05.solvePart2(rules, updates)}")
}