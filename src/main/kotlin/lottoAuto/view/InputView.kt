package lottoAuto.view

import lottoAuto.domain.Lotto
import lottoAuto.domain.LottoNumber
import lottoAuto.domain.LottoNumbers

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val purchaseAmount = readln().toInt()
        require(purchaseAmount > 0) { "구입 금액은 0보다 커야합니다." }
        return purchaseAmount
    }

    fun getWinningLotto(): Lotto {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val winningLottoNumbers = readln().split(",").map { LottoNumber.from(it.toInt()) }
        require(winningLottoNumbers.size == LottoNumbers.NUM_OF_LOTTO_NUMBERS) { "당첨 번호는 6개여야 합니다." }
        return Lotto(
            LottoNumbers(numbers = winningLottoNumbers)
        )
    }
}
