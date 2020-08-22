package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoWinningNumber
import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    // 로또 구매금액 입력
    val inputMoney = InputView.getUserInputMoney()

    // 수동 구매수량 입력
    val inputManualLottoCount = InputView.getManualLottoCount()
    // 수동 번호 입력
    val inputManualLottoNum = InputView.getInputManualLottoNumber(inputManualLottoCount)

    // 로또 게임실행
    val lottoUserTickets = LottoGame.createLottoTicket(inputMoney, inputManualLottoNum)
    OutputView.printLottoTickets(lottoUserTickets)

    // 로또 당첨번호 입력
    val inputLuckyNumber = InputView.getInputLuckyNumber()
    // 보너스볼 입력
    val bonusBall = InputView.getInputBonusNumber()
    val lottoWinningNumber = LottoWinningNumber(inputLuckyNumber, bonusBall)

    // 로또 결과 및 분석
    val results = lottoWinningNumber.getLottoResultsOf(lottoUserTickets)
    OutputView.printLottoResults(results)
    OutputView.printProfitRatio(LottoGame.calculate(inputMoney, results))
}
