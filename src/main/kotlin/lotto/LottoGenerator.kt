package lotto

class LottoGenerator {

    fun generate(): Lotto {
        return Lotto(DEFAULT_RANGE.shuffled().subList(0, 6))
    }

    companion object {
        val DEFAULT_RANGE = IntRange(1, 45)
    }
}
