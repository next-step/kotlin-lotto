package lotto.model

class LottoMaker {
    fun make(): Lotto {
        val numbers =
            List(LOTTO_NUMBER_RANGE) { i -> i + TO_POSITIVE_NUMBER }.shuffled().subList(0, LOTTO_NUMBER_TOTAL_COUNT)
                .sorted()
        return Lotto(numbers)
    }

    companion object {
        const val LOTTO_NUMBER_RANGE = 45
        const val LOTTO_NUMBER_TOTAL_COUNT = 6
        const val TO_POSITIVE_NUMBER = 1
    }
}
