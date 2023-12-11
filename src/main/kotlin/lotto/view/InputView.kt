package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber

interface InputView {
    fun getBudget(): Int

    fun getWinningNumber(): WinningNumber

    fun printPurchasedLotto(autoLottoTickets: LottoTickets, manualLottoTickets: LottoTickets)

    fun getManualLottoCount(): Int

    fun getManualNumbers(manualLottoCount: Int): List<List<Int>>
}
