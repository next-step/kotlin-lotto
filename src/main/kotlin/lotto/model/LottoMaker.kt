package lotto.model

class LottoMaker {
    fun make(): Lotto {
        val numbers =
            List(LOTTO_NUMBER_END) { i -> i + LOTTO_NUMBER_START }
                .shuffled().subList(0, LOTTO_NUMBER_TOTAL_COUNT)
                .sorted()
        return Lotto(numbers.map { LottoNo.from(it) }.toSet())
    }

    companion object {
        const val LOTTO_NUMBER_START = 1
        const val LOTTO_NUMBER_END = 45
        const val LOTTO_NUMBER_TOTAL_COUNT = 6
    }
}
