package calculator

@JvmInline
value class StringAddCalculator(private val text: String) {

    fun add() = when (text.isNotBlank()) {
        true -> text.toInt()
        false -> 0
    }
}
