package stringaddcalculator

class CustomDelimiter {
    private val regex = Regex("//(.)\n(.*)")
    fun find(text: String): MatchResult? {
        return regex.find(text)
    }
}
