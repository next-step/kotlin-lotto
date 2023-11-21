package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto

object InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualLotto(): List<Lotto> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val size = readln().toInt()

        println("수동으로 구매할 번호를 입력해 주세요.")
        return (0 until size).map { Lotto(*inputLotto()) }
    }

    private fun inputLotto(): IntArray {
        return readln()
            .split(",")
            .map { it.trim().toInt() }
            .toIntArray()
    }

    fun inputWinningLotto(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val lotto = inputLotto()
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readln().toInt()
        return WinningLotto(Lotto(*lotto), LottoNumber.create(bonusNumber))
    }
}
