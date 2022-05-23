package lotto

import lotto.domain.LottoMarket

fun main() {
    try {
        println("구입금액을 입력해 주세요.")
        val price = readln().toInt()
        val lottos = LottoMarket.sell(price)

        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln()
            .filter { !it.isWhitespace() }
            .split(",")
            .map { it.toInt() }
    } catch (e: NumberFormatException) {
        println("숫자가 아닌 값이 들어왔습니다")
    }
}
