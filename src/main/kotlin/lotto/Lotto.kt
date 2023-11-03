package lotto

import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    // 구입 금액 입력
    val purchased = InputView().getPurchaseAmount()

    val lottoManager = LottoManager(purchased.toInt())

    // 구매 개수 출력
    OutputView().printPurchasedAmount(lottoManager.getLottoList().size)

    // 로또 발급 및 출력
    lottoManager.generateLotto()
    OutputView().printLottoList(lottoManager.getLottoList())

    // 당첨 번호 입력
    lottoManager.setWinningNumbers(InputView().getWinningNumbers())

    // 통계 출력
    OutputView().printResult(lottoManager.getResult())

    // 수익률 출력
    OutputView().printEarningRate(lottoManager.getResult(), lottoManager.purchased)
}
