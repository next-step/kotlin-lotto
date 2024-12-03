package lotto.domain

import lotto.domain.data.Lotto
import lotto.util.NumberGenerator
import lotto.util.RandomNumberGenerator

class LottoFactory(
    private val totalLottoCount: Int,
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
) {
    fun createLottoList(): List<Lotto> {
        return List(totalLottoCount) {
            numberGenerator
                .getNumbers(LOTTO_NUMBER_SIZE)
                .let { Lotto(it) }
        }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
