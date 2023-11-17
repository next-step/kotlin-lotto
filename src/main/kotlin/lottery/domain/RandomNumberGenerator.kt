package lottery.domain

import lottery.domain.LottoGame.Companion.LOTTO_MAX_NUMBER
import lottery.domain.LottoGame.Companion.LOTTO_MIN_NUMBER

class RandomNumberGenerator : LottoNumberGenerator {
    override fun getNumbers(): List<Int> {
        return NUMBER_LIST.shuffled().take(COUNT_TO_PICK)
    }

    companion object {
        private const val COUNT_TO_PICK = 6
        private val NUMBER_LIST = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
    }
}
