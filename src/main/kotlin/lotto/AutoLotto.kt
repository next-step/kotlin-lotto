package lotto

import lotto.domain.PrizeEvaluator
import lotto.view.InputView
import lotto.view.OutputView
import lotto.vo.LottoTicket

class AutoLotto

fun main() {
    val inputPrice = InputView.readPrice()

    val lottoTickets = AutoLottoController.play(inputPrice)
    val winningTicket = LottoTicket(InputView.inputWinningNumbers().winningNumber)

    OutputView.write(PrizeEvaluator.calculateROI(lottoTickets, winningTicket, inputPrice))
}
