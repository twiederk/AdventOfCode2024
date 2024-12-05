class Day05 {

    fun validatePageOrder(page: Int, rules: Map<Int, List<Int>>, update: List<Int>): Boolean {
        val pageRules = rules[page] ?: return false
        return pageRules.containsAll(update)
    }

}