package lotto.service

import lotto.domain.BuyAmount
import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.service.LottoGenerator.Companion.LOTTO_SIZE
import lotto.service.LottoGenerator.Companion.RANGE_END
import lotto.service.LottoGenerator.Companion.RANGE_START

class RandomLottoGenerator : LottoGenerator {
    override fun generate(buyAmount: BuyAmount): Lottos =
        List(buyAmount.tryCount) {
            generateSingleLotto()
        }.run {
            Lottos.of(this)
        }

    override fun generateSingleLotto(): Lotto = Lotto.of(randomNumbers())

    private fun randomNumbers(): Set<Int> = values.shuffled()
        .subList(RANGE_START, LOTTO_SIZE.plus(1))
        .toSet()

    companion object {
        private val values: List<Int> = (RANGE_START..RANGE_END).toList()
    }
}
