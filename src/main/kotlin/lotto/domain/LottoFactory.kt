package lotto.domain

import lotto.domain.data.Lotto
import lotto.util.RandomNumberGenerator

class LottoFactory(
    private val totalLottoCount: Int,
    private val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator(),
) {
    fun createLottoList(): List<Lotto> {
        return List(totalLottoCount) {
            randomNumberGenerator
                .getRandomNumbers(LOTTO_NUMBER_SIZE)
                .let { Lotto(it) }
        }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
