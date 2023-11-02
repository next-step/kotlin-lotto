package lotto

import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    // 구입 금액 입력
    val purchased = InputView().getPurchaseAmount()

    val lottoManager = LottoManager(purchased)

    // 구매 개수 출력
    OutputView().printPurchasedAmount(lottoManager.getLottoList().size)

    // 발급된 로또 출력
    OutputView().printLottoList(lottoManager.getLottoList())

    // 당첨 번호 입력
    lottoManager.setWinningNumbers(InputView().getWinningNumbers())

    // 통계 출력
    OutputView().printResult(lottoManager.getResult())
}
