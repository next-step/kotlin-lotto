package lotto.service

import lotto.domain.BuyAmount
import lotto.domain.Lotto
import lotto.domain.Lottos

class TestLottoGenerator : LottoGenerator {
    override fun generateSingleLotto(): Lotto = Lotto.of(setOf(1, 2, 3, 4, 5, 6))
    override fun generate(buyAmount: BuyAmount): Lottos {
        val elements = mutableListOf<Lotto>()
        repeat(buyAmount.tryCount) {
            elements.add(generateSingleLotto())
        }
        return Lottos.of(elements)
    }
}
