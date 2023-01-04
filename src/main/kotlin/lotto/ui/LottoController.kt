package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.Round
import lotto.domain.RoundResult
import lotto.domain.Store
import lotto.domain.Ticket
import lotto.domain.WinningLotto
import lotto.ui.view.getBonusLottoNumber
import lotto.ui.view.getManualNumbers
import lotto.ui.view.getPurchasePrice
import lotto.ui.view.getWinningLottoNumbers
import lotto.ui.view.printLottoResult
import lotto.ui.view.printLottos
import lotto.ui.view.printTicketInfo

object LottoController {
    fun runLotteryRound() {
        val ticket = issueTicket()
        printTicketInfo(ticket)

        val purchasedLottos = purchaseLottos(ticket)
        printLottos(purchasedLottos)

        val winningLotto = drawWinningLottos()
        val roundResult = getRoundResult(purchasedLottos, winningLotto)
        val earningRate = roundResult.calculateEarningRate()

        printLottoResult(roundResult, earningRate)
    }

    private fun issueTicket(): Ticket {
        val purchasePrice = Money(
            getPurchasePrice()
        )
        val manualLottoNumbers = getManualNumbers()

        return Ticket(purchasePrice, manualLottoNumbers)
    }

    private fun purchaseLottos(ticket: Ticket): Lottos {
        val autoLottos = Store.purchaseAutoLottos(ticket)
        val manualLottos = Store.purchaseManualLotto(ticket)

        return autoLottos + manualLottos
    }

    private fun drawWinningLottos(): WinningLotto {
        val winningLottoNumbers = getWinningLottoNumbers()
            .map { LottoNumber.of(it) }
            .toSet()
        val bonusNumber = LottoNumber.of(getBonusLottoNumber())

        return WinningLotto(
            Lotto(winningLottoNumbers),
            bonusNumber
        )
    }

    private fun getRoundResult(purchasedLottos: Lottos, winningLotto: WinningLotto): RoundResult {
        return Round(purchasedLottos, winningLotto).aggregate()
    }
}
