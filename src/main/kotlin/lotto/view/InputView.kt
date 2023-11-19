package lotto.view

import lotto.Lotto
import lotto.LottoNumber
import lotto.WinningLotto

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinningNumbers(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln().replace(" ",""). split(",").map { LottoNumber.valueOf(it.toInt()) }
        val winningLotto = convertToLotto(winningNumbers)

        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = LottoNumber(readln().toInt())
        return WinningLotto(winningLotto, bonusNumber)
    }

    private fun convertToLotto(numbers: List<LottoNumber>): Lotto {
        return Lotto(numbers)
    }

}
