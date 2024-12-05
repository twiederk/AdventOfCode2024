import java.nio.file.Path
import kotlin.io.path.name

class Day05 {

    fun validatePageOrder(page: Int, rules: Map<Int, List<Int>>, update: List<Int>): Boolean {
        val pageRules = rules[page] ?: return false
        return pageRules.containsAll(update)
    }

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
        var currentUpdate = update
        while (currentUpdate.isNotEmpty()) {
            val page = currentUpdate[0]
            currentUpdate = currentUpdate.drop(1)
            if (!validatePageOrder(page, rules, currentUpdate)) {
                return false
            }
        }
        return true
    }

}