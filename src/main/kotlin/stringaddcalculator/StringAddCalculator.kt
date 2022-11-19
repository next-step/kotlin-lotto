package stringaddcalculator

class StringAddCalculator {

    fun add(text: String?): Int? {
        if (text.isNullOrBlank()) return 0
        if (text.length == 1) return text.toIntOrNull()

        val numbers: List<String> = text.split("[,:]".toRegex())

        return add(numbers)
    }

    private fun add(text: List<String>): Int {
        var result = 0
        text.forEach { char ->
            char.toIntOrNull()?.let { number ->
                result += number
            }
        }
        return result
    }
}
