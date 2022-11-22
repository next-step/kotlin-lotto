package lotto.view

import lotto.domain.PurchaseResult
import lotto.domain.WinningNumber

object InputView {

    fun purchaseCost(): PurchaseResult {
        println("구입금액을 입력해 주세요.")
        val cost = readln()
        return PurchaseResult(cost)
    }

    fun numberOfPurchase(numberOfGames: Int) {
        println("${numberOfGames}개를 구매했습니다.")
    }

    fun winningNumberOfLastWeek(): WinningNumber {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumberOfLastWeek = readln()
        return WinningNumber(winningNumberOfLastWeek)
    }
}
