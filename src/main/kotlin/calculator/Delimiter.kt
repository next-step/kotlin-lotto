package calculator

@JvmInline
value class Delimiter(
    val delimiter: String
) {
    companion object {
        val DEFAULT = listOf(Delimiter(","), Delimiter(":"))
    }
}
