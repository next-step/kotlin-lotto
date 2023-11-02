package stringaddcalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()){
            return 0
        }

        return parseAdd(text)
    }

    private fun parseAdd(text: String): Int {
        val regex = "[,:]".toRegex()
        return text.split(regex)
            .toList()
            .map { it -> it.toInt() }
            .sum()
    }
}
