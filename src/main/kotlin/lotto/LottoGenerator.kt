package lotto

class LottoGenerator {
    val range = IntRange(1, 45)

    fun generate(): Lotto {
        return Lotto(range.shuffled().subList(0, 6))
    }
}
