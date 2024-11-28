package lotto.view

import lotto.domain.LottoCustomerInput
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.WinningNumbers

object InputView {
    fun drawAndGetPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun drawAndGetSelectLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun drawAndGetLottoCustomerInput(
        purchasePrice: Int,
        selectLottoCount: Int,
    ): LottoCustomerInput {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val selectLottoNumbersList =
            List(selectLottoCount) { LottoNumbers(readln().split(",").map { LottoNumber(it.toInt()) }.toSet()) }
        val lottoCustomerInput = LottoCustomerInput(purchasePrice, selectLottoNumbersList)
        println("수동 ${lottoCustomerInput.getLottoSelectCount()}개 ${lottoCustomerInput.getLottoAutoCount()}개를 구매했습니다.")
        return lottoCustomerInput
    }

    fun drawAndGetWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln().split(",").map { LottoNumber(it.toInt()) }.toSet()
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readln().toInt()
        return WinningNumbers(LottoNumbers(winningNumbers), LottoNumber(bonusNumber))
    }
}
