package calculator


data class Token(private val text: String) {
    init {
        require(text.toIntOrNull() != null && text.toInt() >= 0) {
            RuntimeException()
        }
    }

    val number: Int = text.toInt()
}
