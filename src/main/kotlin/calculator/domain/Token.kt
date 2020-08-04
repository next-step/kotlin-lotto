package calculator.domain

data class Token(private val initialValue: String) {
    val value: Int

    init {
        val number = initialValue.trim().toIntOrNull() ?: throw RuntimeException("0 이상의 수가 아님")
        value = if (number < 0) 0 else number
    }
}
