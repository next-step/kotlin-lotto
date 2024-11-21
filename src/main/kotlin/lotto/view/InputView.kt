package lotto.view

import WinningLotto
import lotto.domain.LottoNumber

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinningNumbers(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln().split(",").map { it.toInt() }

        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readln().toInt()

        return WinningLotto(
            lottoNumbers = numbers.map { LottoNumber.of(it) },
            bonusNumber = LottoNumber.of(bonusNumber),
        )
    }
}
