package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoWinningNumber
import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    // 로또 구매금액 입력
    val inputMoney = InputView.getUserInputMoney()
    val lottoUserTickets = LottoGame.makeTickets(inputMoney)
    OutputView.printLottoTickets(lottoUserTickets)

    // 로또 당첨번호 입력
    val inputLuckyNumber = InputView.getInputLuckyNumber()
    val lottoWinningNumber = LottoWinningNumber(inputLuckyNumber)

    // 로또 결과 및 분석
    val results = lottoWinningNumber.getLottoResultsOf(lottoUserTickets)
    OutputView.printLottoResults(results)
    OutputView.printProfitRatio(LottoGame.calculate(inputMoney, results))
}
