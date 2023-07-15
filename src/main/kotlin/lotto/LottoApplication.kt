package lotto

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.util.RandomNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    // 구매 금액 입력
    val money = InputView.inputMoney()
    val manualLottoCount = InputView.inputManualLottoCount()
    val manualLottoTickets: List<LottoTicket> = InputView.inputManualLottoNumbers(manualLottoCount).map {
        LottoTicket(it)
    }
    val autoLottoTickets: List<LottoTicket> = List(money.countAutoLotto(manualLottoCount)) {
        RandomNumbers.generateNumbers()
    }

    val lottoTickets = LottoTickets(money, manualLottoTickets + autoLottoTickets)

    // 구매 티켓 출력
    OutputView.printPurchase(manualLottoCount, lottoTickets)

    // 당첨번호 입력
    val winTicket = LottoTicket(InputView.inputWinNumbers())
    val bonusNumber = InputView.inputBonusNumber()

    // 당첨 통계
    OutputView.printWinStats(lottoTickets.getWinStats(winTicket, bonusNumber))
}
