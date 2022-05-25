package calculator.model

interface Separable {
    fun isSeparable(input: String): Boolean

    fun separate(input: String): List<String>
}
