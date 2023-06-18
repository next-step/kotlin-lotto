package calculator

class Delimiters(private val delimiters: MutableList<String>) {
    companion object {
        private var defaultDelimiters = mutableListOf(",", ":")
        val DEFAULT = Delimiters(defaultDelimiters)
    }

    fun getDelimiters(): List<String> = delimiters.toList()

    fun addCustomDelimiters(vararg customDelimiters: String) {
        delimiters.addAll(customDelimiters)
    }
}
