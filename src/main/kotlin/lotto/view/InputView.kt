package lotto.view

import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.PurchaseGames
import lotto.model.WinningNumbers

object InputView {
    fun purchaseAmount(pricePerGame: Int): PurchaseGames {
        println("구입금액을 입력해 주세요.")
        val totalPurchaseCount: Int = readln().toInt() / pricePerGame
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualCount: Int = readln().toInt()
        println("수동으로 구매할 번호를 입력해 주세요.")
        return PurchaseGames(totalPurchaseCount, manualCount, manualInput(manualCount))
    }

    private fun manualInput(count: Int): String {
        return (1..count)
            .asSequence()
            .map { requireNotNull(readlnOrNull()) }
            .joinToString(separator = "\n")
    }

    fun selectWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = LottoNumbers((readlnOrNull() ?: "").split(",").map { it.toInt() })
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = LottoNumber((readlnOrNull() ?: "").toInt())
        return WinningNumbers(winningNumbers, bonusNumber)
    }
}
