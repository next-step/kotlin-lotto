package lotto

import lotto.domain.LottoCustomerInput
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoResult
import lotto.domain.WinningNumbers
import lotto.view.LottoView

fun main() {
    println("구입금액을 입력해 주세요.")
    val purchasePrice = readln().toInt()
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    val selectLottoCount = readln().toInt()
    println("수동으로 구매할 번호를 입력해 주세요.")

    val selectLottoNumbersList = List(selectLottoCount) { LottoNumbers(readln().split(",").map { LottoNumber(it.toInt()) }.toSet()) }
    val lottoCustomerInput = LottoCustomerInput(purchasePrice, selectLottoNumbersList)

    println("수동 ${lottoCustomerInput.getLottoSelectCount()}개 ${lottoCustomerInput.getLottoAutoCount()}개를 구매했습니다.")
    println("지난 주 당첨 번호를 입력해 주세요.")
    val winningNumbers = readln().split(",").map { LottoNumber(it.toInt()) }.toSet()
    println("보너스 볼을 입력해 주세요.")
    val bonusNumber = readln().toInt()

    val lottoResult = LottoResult.getLottoResult(lottoCustomerInput, WinningNumbers(LottoNumbers(winningNumbers), LottoNumber(bonusNumber)))

    LottoView.drawLottos(lottoResult)
    LottoView.drawMatchMap(lottoResult)
    LottoView.drawProfitRate(lottoResult)
}
