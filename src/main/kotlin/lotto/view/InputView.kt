package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto

object InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputWinningLotto(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val lotto = readln().split(",").map { it.trim().toInt() }
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readln().toInt()
        return WinningLotto(Lotto(*lotto.toIntArray()), LottoNumber(bonusNumber))
    }
}
