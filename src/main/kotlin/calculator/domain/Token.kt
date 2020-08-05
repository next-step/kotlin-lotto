package calculator.domain

data class Token(private val initialValue: String) {
    val value: Int

    init {
        val number = initialValue.trim().toIntOrNull() ?: throw RuntimeException()
        value = if (number > 0) number else throw RuntimeException()
    }
}
