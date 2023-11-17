package lotto.view

import lotto.model.Game
import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.PurchaseGames
import lotto.model.WinningNumbers

object InputView {

    const val LOTTO_NUMBER_DELIMITER = ","
    private const val GAME_DELIMITER = "\n"

    fun purchaseAmount(priceOfGame: Int): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt() / priceOfGame
    }

    private fun manualIssue(manualTicketingInput: String): List<Game> {
        return manualTicketingInput.split(GAME_DELIMITER)
            .asSequence()
            .map { it.stringToGame() }
            .toList()
    }

    private fun manualInput(count: Int): String {
        return (1..count)
            .asSequence()
            .map { requireNotNull(readlnOrNull()) }
            .joinToString(separator = "\n")
    }

    fun selectWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = LottoNumbers((readlnOrNull() ?: "").split(LOTTO_NUMBER_DELIMITER).map { it.toInt() })
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = LottoNumber((readlnOrNull() ?: "").toInt())
        return WinningNumbers(winningNumbers, bonusNumber)
    }

    fun purchaseManual(totalPurchaseCount: Int): PurchaseGames {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualCount: Int = readln().toInt()
        println("수동으로 구매할 번호를 입력해 주세요.")
        return PurchaseGames(totalPurchaseCount, manualCount, manualIssue(manualInput(manualCount)))
    }
}

private fun String.stringToGame(): Game {
    return Game(
        LottoNumbers(
            this.split(InputView.LOTTO_NUMBER_DELIMITER)
                .map { it.toInt() }
        )
    )
}
