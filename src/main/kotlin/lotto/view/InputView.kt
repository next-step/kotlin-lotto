package lotto.view

import lotto.domain.Ticket

class InputView {
    fun enterPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("Please enter a valid purchase.")
    }

    fun enterWinningNumbers(): List<Int> {
        println("\nPlease enter last week’s winning numbers.")
        return enterLottoNumbers()
    }

    fun enterBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = readlnOrNull() ?: throw IllegalArgumentException("Please enter a valid number.")
        return input.toIntOrNull() ?: throw java.lang.IllegalArgumentException("Please enter a valid number.")
    }

    fun enterManualTickets(): List<Ticket> {
        println("\nEnter the number of manual tickets to purchase:")
        val numberOfManualTickets = readlnOrNull()?.toIntOrNull()
            ?: throw IllegalArgumentException("Please enter a valid number of manual tickets.")

        println("\nEnter the numbers for manual tickets.")
        val tickets = mutableListOf<Ticket>()
        repeat(numberOfManualTickets) {
            tickets.add(Ticket(enterLottoNumbers()))
        }
        return tickets
    }

    private fun enterLottoNumbers(): List<Int> {
        val input = readlnOrNull() ?: throw IllegalArgumentException("Please enter a valid numbers.")
        return input.split(",").map {
            it.trim().toIntOrNull()
                ?: throw IllegalArgumentException("Please enter a valid numbers.")
        }
    }
}
