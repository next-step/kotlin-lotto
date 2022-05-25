package calculator.model

interface SepartorStrategy {
    fun isSeparable(input: String): Boolean

    fun separate(input: String): List<String>
}
