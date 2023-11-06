package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoManager
import lotto.tokenizeWinningNumbers
import lotto.view.Input
import lotto.view.Output

fun main() {
    // 구입 금액 입력
    val purchased = Input().getPurchaseAmount()

    val lottoManager = LottoManager(purchased.toInt())

    // 구매 개수 출력
    Output().printPurchasedAmount(lottoManager.lottoAmount)

    // 로또 발급 및 출력
    lottoManager.generateLottos()
    Output().printLottoList(lottoManager.lottos.lottoList)

    // 당첨 번호 입력
    val winningNumbers = Input().getWinningNumbers()

    // 당첨 번호 등록
    Lotto(tokenizeWinningNumbers(winningNumbers)).let { lottoManager.setWinningNumbers(it) }

    // 통계 출력
    Output().printResult(lottoManager.getResult())

    // 수익률 출력
    Output().printEarningRate(lottoManager.getResult(), lottoManager.purchased)
}
