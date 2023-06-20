package calculator

interface Separator {
    fun separate(expression: String): List<Int>
}