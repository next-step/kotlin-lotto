package calculator

enum class Patterns(val regex: Regex) {
    DEFAULT_DELIMITER("[,:]".toRegex()),
    CUSTOM_DELIMITER("//(.*?)\\n".toRegex()),
    NONE("".toRegex()),
    ;

    fun hasMatch(expression: String): Boolean {
        return regex.containsMatchIn(expression)
    }
}
