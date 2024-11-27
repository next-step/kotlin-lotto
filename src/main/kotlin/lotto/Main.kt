package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoCreator = LottoCreator()
    val lottoShop = LottoShop(lottoCreator)
    val winningLottoMatcher = WinningLottoMatcher()

    // 주문 생성
    val amount = InputView.getAmount()
    val order = lottoShop.makeOrder(amount)
    ResultView.printCreatedLottos(order.lottos)

    // 당첨번호 및 보너스번호 생성
    val winNumberInput = InputView.getWinNumberInput()
    val bonusNumber = InputView.getBonusNumber()
    val winNumbers = lottoCreator.createWinningLotto(winNumberInput, bonusNumber)

    // 결과 출력
    val result = winningLottoMatcher.checkAndGetResult(order, winNumbers)
    ResultView.printResult(result)
}
