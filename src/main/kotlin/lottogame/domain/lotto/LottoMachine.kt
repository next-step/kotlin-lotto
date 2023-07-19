package lottogame.domain.lotto

import lottogame.domain.GameMoney
import lottogame.domain.generator.LottoGenerator
import lottogame.domain.generator.RandomLottoGenerator

class LottoMachine(private val lottoGenerator: LottoGenerator = RandomLottoGenerator()) {
    fun toWinningLotto(winningNumbers: List<Int>, bonusNumber: Int): WinningLotto {
        return WinningLotto.from(winningNumbers, bonusNumber)
    }

    fun generateTicket(gameMoney: GameMoney, lottos: List<List<Int>>): LottoTicket {
        val manualLottos = lottos.map { Lotto.of(it, GenerationType.MANUAL) }
        val purchaseCount = gameMoney.calculatePurchaseCount()
        val autoLottos = List(purchaseCount - manualLottos.size) { lottoGenerator.get() }

        return LottoTicket(manualLottos + autoLottos)
    }
}
