package step2.lotto.service

import step2.lotto.domain.BuyAmount
import step2.lotto.domain.Lotto
import step2.lotto.domain.Lottos

class TestLottoGenerator : LottoGenerator {
    override fun generateSingleLotto(): Lotto = Lotto.of(setOf(1, 2, 3, 4, 5, 6))
    override fun generate(buyAmount: BuyAmount): Lottos {
        val elements = mutableListOf<Lotto>()
        repeat(buyAmount.tryCount){
            elements.add(generateSingleLotto())
        }
        return Lottos.of(elements)
    }
}
