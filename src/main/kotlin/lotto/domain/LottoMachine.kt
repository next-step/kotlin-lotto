package lotto.domain

import lotto.domain.generator.LottoGenerator
import lotto.domain.generator.RandomLottoGenerator
import java.math.BigDecimal

class LottoMachine(private val lottoGenerator: LottoGenerator = RandomLottoGenerator()) {
    fun generateTicket(money: Money): LottoTicket {
        require(money.value % UNIT == BigDecimal.ZERO) { "금액은 ${UNIT}원 단위로 입력해야 합니다. [$money]" }
        val purchaseCount = money.divide(UNIT).toInt()
        return List(purchaseCount) { lottoGenerator.get() }
            .run(::LottoTicket)
    }

    fun toWinningLotto(winningNumbers: List<Int>, bonusNumber: Int): WinningLotto {
        return WinningLotto.from(winningNumbers, bonusNumber)
    }

    companion object {
        private val UNIT = 1_000.toBigDecimal()
    }
}
