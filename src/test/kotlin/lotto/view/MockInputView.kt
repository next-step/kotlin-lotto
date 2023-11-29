package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber

class MockInputView(
    private val budget: Int,
    private val winningNumber: WinningNumber,
) : InputView {
    override fun getBudget(): Int = budget

    override fun getWinningNumber(): WinningNumber = winningNumber

    override fun printPurchasedLotto(lottoTickets: LottoTickets) = Unit
}
