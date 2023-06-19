package calculator

class Delimiters(private val delimiters: List<String> = listOf(",", ":")) {
    fun getDelimiters(): List<String> = delimiters

    fun addCustomDelimiters(vararg customDelimiters: String): Delimiters {
        val newDelimiters = delimiters + customDelimiters
        return Delimiters(newDelimiters)
    }
}
