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
                .getNumbers(Lotto.MIN_LOTTO_COUNT)
                .let { Lotto(it) }
        }
    }
}
