package calculator

class StringAddCalculator {

    fun split(input: String): List<String> {
        return input.split(",|:".toRegex())
    }
}
