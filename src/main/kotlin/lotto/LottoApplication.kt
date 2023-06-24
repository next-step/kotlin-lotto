package lotto

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.util.RandomNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main(args: Array<String>) {
    // 구매 금액 입력
    val money = InputView.inputMoney()
    val manualLottoCount = InputView.inputManualLottoCount()
    val manualLottoTickets = InputView.inputManualLottoNumbers(manualLottoCount)
    val autoLottoTickets: List<LottoTicket> = List(money.countLotto() - manualLottoCount) {
        LottoTicket(RandomNumbers.generateNumbers())
    }

    val lottoTickets = LottoTickets(money, manualLottoTickets + autoLottoTickets)

    // 구매 티켓 출력
    OutputView.printPurchase(manualLottoCount, lottoTickets)

    // 당첨번호 입력
    val winNumbers = InputView.inputWinNumbers()
    val bonusNumber = InputView.inputBonusNumber()

    // 당첨 통계
    OutputView.printWinStats(lottoTickets.getWinStats(winNumbers, bonusNumber))
}
