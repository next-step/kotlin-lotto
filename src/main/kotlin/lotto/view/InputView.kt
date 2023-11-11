package lotto.view

import lotto.domain.Lotto

object InputView {
    private const val DELIMITER = ", "
    fun enterMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun enterWinningLotto(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(DELIMITER).map { it.trim().toInt() }
    }
}
