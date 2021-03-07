package lotto.controller

import lotto.model.LottoChecker
import lotto.model.LottoStore
import lotto.model.Money

fun main() {
    println("구입금액을 입력해 주세요.")
    val moneyAmount = readLine()!!.toInt()

    val store = LottoStore()
    val tickets = store.buy(Money(moneyAmount))

    println("지난 주 당첨 번호를 입력해 주세요.")
    val winningNumbers = readLine()!!.split(",").map { it.toInt() }

    val checker = LottoChecker(winningNumbers)
    val result = checker.check(tickets, Money(moneyAmount))

    println(result)
}