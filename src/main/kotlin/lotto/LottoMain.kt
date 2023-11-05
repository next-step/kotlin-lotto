package lotto

import lotto.ui.InputView
import lotto.ui.OutputView
import lotto.util.StringHandler

fun main() {
    // 구입 금액 입력
    val purchased = InputView().getPurchaseAmount()

    val lottoManager = LottoManager(purchased.toInt())

    // 구매 개수 출력
    OutputView().printPurchasedAmount(lottoManager.lottoAmount)

    // 로또 발급 및 출력
    lottoManager.generateLottos()
    OutputView().printLottoList(lottoManager.lottos.lottoList)

    // 당첨 번호 입력
    val winningNumbers = InputView().getWinningNumbers()

    // 당첨 번호 등록
    Lotto(StringHandler().tokenizeWinningNumbers(winningNumbers)).let { lottoManager.setWinningNumbers(it) }

    // 통계 출력
    OutputView().printResult(lottoManager.getResult())

    // 수익률 출력
    OutputView().printEarningRate(lottoManager.getResult(), lottoManager.purchased)
}
