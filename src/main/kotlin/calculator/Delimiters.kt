package calculator

class Delimiters private constructor(private val delimiters: MutableList<String>) {
    companion object {
        private var delimiters = mutableListOf(",", ":")
        val DEFAULT = Delimiters(delimiters)
    }

    fun getDelimiters(): List<String> = delimiters

    fun addCustomDelimiters(vararg customDelimiters: String) {
        delimiters.addAll(customDelimiters)
    }
}
