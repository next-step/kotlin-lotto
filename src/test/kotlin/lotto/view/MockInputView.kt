package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber

class MockInputView(
    private val budget: Int,
    private val winningNumber: WinningNumber,
    private val manualNumbersList: List<List<Int>>,
) : InputView {
    override fun getBudget(): Int = budget

    override fun getWinningNumber(): WinningNumber = winningNumber

    override fun printPurchasedLotto(autoLottoTickets: LottoTickets, manualLottoTickets: LottoTickets) = Unit

    override fun getManualLottoCount(): Int = manualNumbersList.size

    override fun getManualNumbers(manualLottoCount: Int): List<List<Int>> = manualNumbersList
}
