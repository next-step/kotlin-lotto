package lotto.view

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.domain.ManualPurchaseResult
import lotto.domain.PurchaseResult
import lotto.domain.WinningNumber

object InputView {

    fun purchaseCost(): PurchaseResult {
        println("구입금액을 입력해 주세요.")
        val cost = readln()
        return PurchaseResult(cost)
    }

    fun winningNumberOfLastWeek(): WinningNumber {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumberOfLastWeek = readln()
        return WinningNumber(winningNumberOfLastWeek)
    }

    fun bonusNumberOfLastWeek(winnerNumber: WinningNumber): BonusNumber {
        println()
        println("보너스 볼을 입력해 주세요.")
        val bonusNumberOfLastWeek = readln()
        return BonusNumber(bonusNumberOfLastWeek, winnerNumber)
    }

    fun numberOfManualPurchase(numberOfGamesAvailable: Int): ManualPurchaseResult {
        println()
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val number = readln()
        return ManualPurchaseResult(number, numberOfGamesAvailable)
    }

    fun pickManualLottoNumber(numberOfManual: Int): List<Lotto> {
        if (numberOfManual == 0) return mutableListOf()
        println()
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(numberOfManual) {
            val number = readln()
            WinningNumber(number).winnerNumber
        }
    }
}
