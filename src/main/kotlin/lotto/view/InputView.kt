package lotto.view

import lotto.domain.WinningLotto

object InputView {
    fun getUserAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val amount: String = readln()
        return amount.toInt()
    }

    fun getUserWinningLotto(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLottoNumbers: String = readln()
        val numbers = winningLottoNumbers.split(",").map { it.toInt() }
        // require(numbers.size == 6) { "당첨 번호 입력이 유효하지 않습니다"}
        return WinningLotto(numbers)
    }
}
