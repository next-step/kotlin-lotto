package lotto

import lotto.model.Lotto
import lotto.service.LottoPlayResultAnalysis
import lotto.service.LottoTicketCountCalculator
import lotto.view.LottoPlayer
import lotto.view.LottoVendor
import lotto.view.LottoVendor.printLottoNumber
import lotto.view.LottoVendor.saleLottoTicket
import util.StringUtil.toIntList

const val COMMA_SEPARATOR = ","

fun main() {
    val purchaseAmount = saleLottoTicket()
    val ticketCount = LottoTicketCountCalculator.getCount(purchaseAmount)
    saleLottoTicket(ticketCount)

    val purchasedLottos: MutableList<Lotto> = MutableList(ticketCount) {
        Lotto()
    }

    printLottoNumber(purchasedLottos)

    val lastWeekWinningString = LottoVendor.readLastWeekWinningString()
    val lastWeekWinningNumbers: List<Int> = toIntList(lastWeekWinningString)
    purchasedLottos.forEach { it.setLottoPrize(lastWeekWinningNumbers) }
    val winningRatio = LottoPlayResultAnalysis.getWinningRatio(purchaseAmount, purchasedLottos)
    LottoPlayer.printResult(purchasedLottos, winningRatio)
}
