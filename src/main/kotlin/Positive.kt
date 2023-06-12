@JvmInline
value class Positive private constructor(
    val number: Int,
) {
    fun add(positive: Positive) = Positive(number + positive.number)

    companion object {
        operator fun invoke(number: Int): Positive {
            require(number >= 0) { "음수는 입력할 수 없습니다." }
            return Positive(number)
        }
    }
}
