package calculator

class Delimiters(private val delimiters: List<String> = listOf(",", ":")) {
    fun getDelimiters(): List<String> = delimiters

    fun plusCustomDelimiters(vararg customDelimiters: String): Delimiters {
        val newDelimiters = delimiters + customDelimiters
        return Delimiters(newDelimiters)
    }
}
