package calculator

enum class Delimiter(val value: String) {
    COMMA(","), COLON(":")
    ;

    companion object {
        fun valuesArray() = values().map { it.value }.toTypedArray()
    }
}
