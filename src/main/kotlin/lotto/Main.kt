package lotto

import lotto.domain.LottoTicket
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    // 사용자로부터 금액을 입력받는다
    val money = InputView.inputMoney()

    // 수동으로 구매할 로또 수를 입력받는다
    val menualCount = InputView.inputManualNumberCount(money)

    // menualCount만큼 수동으로 구매할 번호들을 입력받는다
    val lottos = InputView.inputManualNumber(menualCount)

    // 로또티켓을 오토로 구매한다
    val lottoTicket = LottoTicket(money)

    // 구매 갯수와 로또 티켓 번호들을 출력한다
    ResultView.printLottos(lottoTicket)

    // 사용자로부터 지난주 당첨번호를 입력받아 WinningLotto객체를 생성한다
    val winningNumber = InputView.inputWinningNumber()
    val bonusNumber = InputView.inputBonusNumber()
    val winningLotto = WinningLotto(winningNumber, bonusNumber)

    // 구매한 LottoTicket과 당첨번호를 확인한다
    val lottoResult = lottoTicket.match(winningLotto)
    ResultView.printResult(lottoResult)
    val totalRate = lottoResult.calculateTotalRate(money)
    ResultView.printTotalRate(totalRate)
}
