package lottoAuto.view

import lottoAuto.domain.LottoNumber.Companion.toLottoNumber
import lottoAuto.domain.WinningLotto

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val purchaseAmount = readln().toInt()
        require(purchaseAmount > 0) { "구입 금액은 0보다 커야합니다." }
        return purchaseAmount
    }

    fun getWinningLotto(): WinningLotto {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val winningLottoNumbers = readln().split(",").map { it.toInt().toLottoNumber() }
        return WinningLotto(winningLottoNumbers)
    }
}
