package lotto

import lotto.domain.LottoSeller
import lotto.domain.WinningNumbers
import lotto.view.LottoView

fun main() {
    println("구입금액을 입력해 주세요.")
    val purchasePrice = readln().toInt()
    val lottoSeller = LottoSeller(purchasePrice)
    val lottos = lottoSeller.sellLottos()
    println("${lottoSeller.getLottoPurchaseCount()}개를 구매했습니다.")
    println("지난 주 당첨 번호를 입력해 주세요.")
    val winningNumbers = readln().split(",").map { it.toInt() }
    val lottoResult = lottoSeller.getLottoResult(lottos, WinningNumbers(winningNumbers))
    val lottoView = LottoView()

    lottoView.drawLottos(lottoResult)
    lottoView.drawResultMap(lottoResult)
    lottoView.drawProfitRate(lottoResult)
}
