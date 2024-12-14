package lotto.view

import lotto.domain.BonusNumber
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.WinningLotto

object InputView {
    fun getUserAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val amount = readln()
        return amount.toIntOrNull() ?: throw IllegalArgumentException("구입 금액이 유효하지 않습니다. 숫자를 입력해주세요")
    }

    fun getUserWinningLotto(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLottoNumbers: String = readln()
        val numbers = winningLottoNumbers.split(",").map { it.toInt() }.toSet()

        val lottoTicket = LottoTicket.from(numbers)
        println("보너스 볼을 입력해 주세요.")
        val number: String = readln()
        return WinningLotto(lottoTicket, number)
    }
}
