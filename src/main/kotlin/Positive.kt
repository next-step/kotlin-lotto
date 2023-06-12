@JvmInline
value class Positive(
    val number: Int,
) {
    init {
        require(number >= 0) { "음수는 입력할 수 없습니다." }
    }

    fun add(positive: Positive) = Positive(number + positive.number)
}
