package lotto.domain.strategy.lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

class LottoAutoGenerateStrategy : LottoGenerateStrategy {
    override fun generate(): LottoTicket {
        return LottoTicket(
            (START_NUMBER..END_NUMBER).shuffled()
                .take(LOTTO_NUMBER_COUNT)
                .map { LottoNumber(it) }
                .toSet()
        )
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
    }
}
