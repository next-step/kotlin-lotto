package calculator

enum class Patterns(val regex: Regex) {

    DEFAULT("[,:]".toRegex()),
    CUSTOM("//(.*?)\\n".toRegex()),
    NONE("".toRegex())
    ;

    fun hasMatch(expression: String): Boolean {
        return regex.containsMatchIn(expression)
    }
}