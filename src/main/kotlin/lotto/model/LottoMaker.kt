package lotto.model

import kotlin.random.Random

class LottoMaker {
    fun make(): Lotto {
        val lotto = Lotto(mutableListOf())

        while (lotto.numbers.size < LOTTO_NUMBER_TOTAL_COUNT) {
            lotto.add(getRandomNumber())
        }
        return lotto
    }

    private fun getRandomNumber(): Int {
        return Random.nextInt(LOTTO_NUMBER_RANGE) + TO_POSITIVE_NUMBER
    }

    companion object {
        const val LOTTO_NUMBER_RANGE = 45
        const val LOTTO_NUMBER_TOTAL_COUNT = 6
        private const val TO_POSITIVE_NUMBER = 1
    }
}
