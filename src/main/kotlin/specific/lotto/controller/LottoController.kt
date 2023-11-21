package specific.lotto.controller

import specific.lotto.domain.*
import specific.lotto.view.InputView
import specific.lotto.view.OutputView
import kotlin.math.min

class LottoController {

    fun participateRound(): Round {
        val player = Player(inputMoney(), TicketMachine())
        OutputView.printTickets(player.tickets)
        val winningNumbers = inputWinningNumbers()
        val round = Round(player, winningNumbers)
        OutputView.printWinningResult(round.winningResult)
        OutputView.printReturnOnInvestment(round.player.money.calculateReturnOnInvestment())
        return round
    }

    private fun inputMoney(): Money {
        val moneyInput = InputView.getMoney()
        require(!moneyInput.isNullOrBlank()) { "'moneyInput' cannot be null or blank" }
        val principal = moneyInput.toLongOrThrow { "'moneyInput' should be convertible to Int" }
        return Money(principal)
    }

    private fun inputWinningNumbers(): WinningNumbers {
        val mainNumbersInput = InputView.getMainNumbers()
        val bonusNumberInput = InputView.getBonusNumber()
        require(!mainNumbersInput.isNullOrBlank()) { "'mainNumbersInput' cannot be null or blank" }
        require(!bonusNumberInput.isNullOrBlank()) { "'bonusNumberInput' cannot be null or blank" }
        val mainNumbers = mainNumbersInput
            .split(", ")
            .map { it.toIntOrThrow { "lotto number should be convertible to Int" } }
        val bonusNumber = bonusNumberInput.toIntOrThrow { "lotto number should be convertible to Int" }
        return WinningNumbers(mainNumbers, bonusNumber)
    }

    private fun String?.toIntOrThrow(lazyMessage: () -> Any): Int {
        require(!isNullOrBlank()) { lazyMessage }
        return this.toIntOrNull()
            ?: throw IllegalArgumentException(lazyMessage().toString())
    }

    private fun String?.toLongOrThrow(lazyMessage: () -> Any): Long {
        require(!isNullOrBlank()) { lazyMessage }
        return this.toLongOrNull()
            ?: throw IllegalArgumentException(lazyMessage().toString())
    }
}
