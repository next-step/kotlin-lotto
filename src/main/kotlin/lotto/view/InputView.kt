package lotto.view

import lotto.domain.LottoNumber

class InputView {
    private val amount: Int by lazy {
        println("구입금액을 입력해 주세요.")
        readln().toInt()
    }

    private val winningNumbers: List<LottoNumber> by lazy {
        println("지난 주 당첨 번호를 입력해 주세요.")
        readln().split(",")
            .map { it.trim() }
            .map { it.toInt() }
            .map { LottoNumber(it) }
    }

    fun amount(): Int = amount

    fun winningNumbers(): List<LottoNumber> = winningNumbers
}
