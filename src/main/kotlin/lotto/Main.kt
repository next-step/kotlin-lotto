package lotto

import lotto.domain.LottoResult
import lotto.domain.LottoSeller
import lotto.domain.WinningNumbers
import lotto.view.LottoView

fun main() {
    println("구입금액을 입력해 주세요.")
    val purchasePrice = readln().toInt()
    val lottoSeller = LottoSeller()
    val lottos = lottoSeller.sellLottos(purchasePrice)
    println("${lottoSeller.getLottoPurchaseCount(purchasePrice)}개를 구매했습니다.")
    println("지난 주 당첨 번호를 입력해 주세요.")
    val winningNumbers = readln().split(",").map { it.toInt() }
    println("보너스 볼을 입력해 주세요.")
    val bonusNumber = readln().toInt()
    val lottoResult = LottoResult.getLottoResult(lottos, WinningNumbers(winningNumbers), bonusNumber, purchasePrice)
    val lottoView = LottoView()

    lottoView.drawLottos(lottoResult)
    lottoView.drawResultMap(lottoResult)
    lottoView.drawProfitRate(lottoResult)
}
