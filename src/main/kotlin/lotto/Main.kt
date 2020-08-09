package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoWinningNumber
import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    // 로또 구매금액 입력
    val inputMoney = InputView.getUserInputMoney()
    val lottoGame = LottoGame()
    val lottoUserTickets = lottoGame.makeTickets(inputMoney)
    OutputView.printLottoTickets(lottoUserTickets)

    // 로또 당첨번호 입력
    val inputLuckyNumber = InputView.getInputLuckyNumber()
    val LottoWinningNumber = LottoWinningNumber()
    LottoWinningNumber.createLuckyTicket(inputLuckyNumber)

    // 로또 결과 및 분석
}
