package expressioncalculator.parser

sealed interface ParseResult {
    data class Success(val numbers: List<Int>) : ParseResult
    data class Failed(val expression: String?) : ParseResult
}
