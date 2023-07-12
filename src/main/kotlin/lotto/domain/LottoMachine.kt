package lotto.domain

import lotto.domain.generator.LottoGenerator
import lotto.domain.generator.RandomLottoGenerator
import java.math.BigDecimal

class LottoMachine(private val lottoGenerator: LottoGenerator = RandomLottoGenerator()) {
    fun toWinningLotto(winningNumbers: List<Int>, bonusNumber: Int): WinningLotto {
        return WinningLotto.from(winningNumbers, bonusNumber)
    }

    fun generateTicket(money: Money, lottos: List<List<Int>>): LottoTicket {
        require(money >= MIN_MONEY) { "금액은 ${MIN_MONEY}원 이상이어야 합니다. [${money.value}]" }
        require(money % MONEY_UNIT == BigDecimal.ZERO) { "금액은 ${MONEY_UNIT}원 단위로 입력해야 합니다. [${money.value}]" }

        val manualLottos = lottos.map { Lotto.of(it, GenerationType.MANUAL) }
        val purchaseCount = money.divide(MONEY_UNIT).toInt()
        val autoLottos = List(purchaseCount - manualLottos.size) { lottoGenerator.get() }

        return LottoTicket(manualLottos + autoLottos)
    }

    companion object {
        private val MONEY_UNIT = Money.from(1_000)
        private val MIN_MONEY = Money.from(1_000)
    }
}
