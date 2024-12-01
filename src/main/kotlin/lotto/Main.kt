package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoCreator = LottoCreator()
    val lottoShop = LottoShop(lottoCreator)

    // 주문 생성
    val amount = InputView.getAmount()
    val manualLottoCount = InputView.getManualLottoCount()
    val manualLottoNumbers = InputView.getManualLottoNumbers(manualLottoCount)
    val manualLottos = lottoCreator.createManualLottos(manualLottoNumbers)
    val order = lottoShop.makeOrder(amount, manualLottoCount, manualLottos)
    ResultView.printCreatedLottos(order)

    // 당첨번호 및 보너스번호 생성
    val winNumberInput = InputView.getWinNumberInput()
    val bonusNumber = InputView.getBonusNumber()
    val winningLotto = lottoCreator.createWinningLotto(winNumberInput, bonusNumber)

    // 결과 출력
    val result = winningLotto.extractWinningResult(order)
    ResultView.printResult(result)
}
