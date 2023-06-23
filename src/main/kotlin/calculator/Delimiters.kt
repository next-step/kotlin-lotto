package calculator

class Delimiters(private val delimiter: String? = null) {
    private val delimiters = mutableListOf<String>(",", ":")

    init {
        if (!delimiter.isNullOrEmpty()) {
            delimiters.add(delimiter)
        }
    }

    fun getDelimiters(): List<String> = delimiters
}
