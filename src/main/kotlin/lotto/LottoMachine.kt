package lotto

import lotto.generator.LottoGenerator
import lotto.generator.RandomLottoGenerator

class LottoMachine(private val lottoGenerator: LottoGenerator = RandomLottoGenerator()) {
    fun generateTicket(money: Int): LottoTicket {
        val purchaseCount = money / 1000
        return List(purchaseCount) { lottoGenerator.get() }
            .run(::LottoTicket)
    }
}
