package calculator

class StringAddCalculator {

    fun add(input: String?): Long {

        if (input.isNullOrBlank()) {
            return 0L
        }

        val numbers = input.split(",|:".toRegex())

        var result = 0L
        numbers.forEach {
            result += it.toLong()
        }

        return result
    }
}
