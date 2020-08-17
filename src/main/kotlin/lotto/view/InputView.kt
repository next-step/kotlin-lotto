package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.WinningLotto

object InputView {

    fun purchasePrice(): Int {

        println("구입금액을 입력해 주세요.")
        val price = readLine()

        return price!!.toInt()
    }

    fun lastWinningLotto(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val text = readLine()

        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine()

        return WinningLotto(
            LottoTicket(splitNumbers(text!!).map { LottoNumber.get(it.toInt()) }.toSet()),
            LottoNumber.get(bonusNumber!!.toInt())
        )
    }
}

fun splitNumbers(numbers: String) = numbers
    .split(",")
    .filter { it.isNotBlank() }
    .map { it.trim() }
    .toSet()
