package lotto.view

import lotto.vo.LottoNumber
import lotto.vo.Money

object InputView {
    fun inputPrice(): Money {
        println("구입금액을 입력해 주세요.")
        val price = readLine()
        require(!price.isNullOrBlank()) { "입력값은 null 혹은 공백이 될 수 없습니다." }
        return Money.from(price)
    }

    fun inputWinnerNumber(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winnerNumber = readLine()
        require(!winnerNumber.isNullOrBlank()) { "입력값은 null 혹은 공백이 될 수 없습니다." }
        return winnerNumber.split(",").map { LottoNumber.from(it.trim()) }
    }
}
