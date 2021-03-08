package lotto.controller

import lotto.model.LottoChecker
import lotto.model.LottoStore
import lotto.view.InputView

fun main() {
    val moneyAmount = InputView.readMoney("구입금액을 입력해 주세요.")

    val store = LottoStore()
    val tickets = store.buy(moneyAmount)

    val winningNumbers = InputView.readWinningNumbers("지난 주 당첨 번호를 입력해 주세요.")

    val checker = LottoChecker(winningNumbers)
    val result = checker.check(tickets, moneyAmount)

    println(result)
}
