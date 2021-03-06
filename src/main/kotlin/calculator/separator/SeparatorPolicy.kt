package calculator.separator

interface SeparatorPolicy {
    fun canSeparate(expression: String?): Boolean

    fun separate(expression: String?): List<String>
}
