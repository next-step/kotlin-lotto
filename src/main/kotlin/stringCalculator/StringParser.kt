package stringCalculator

class StringParser {
    fun parse(inputString: String): List<String> {
        return inputString.split(":", ",")
    }
}