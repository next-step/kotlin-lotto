package lotto

import lotto.domain.PrizeEvaluator.evaluateTotalPrize
import lotto.domain.Ticket
import lotto.view.InputView.readNumbers
import lotto.view.InputView.readPrice
import lotto.view.OutputView.writeROI
import lotto.view.OutputView.writeSingleOutput

class AutoLotto private constructor(private val chance: Int) {
    var tickets: ArrayList<Ticket> = arrayListOf()

    init {
        repeat(chance) {
            val numbers = (1..45).shuffled().take(6).sorted()
            val ticket = Ticket(numbers)
            writeSingleOutput(numbers.toString())

            tickets.add(ticket)
        }
    }

    fun getWinningTicket(input: String): Ticket {
        val numbers = input.replace("\\s".toRegex(), "").split(",").map { it.toInt() }
        writeSingleOutput(numbers.toString())
        return Ticket(numbers)
    }

    companion object {
        fun play(money: Int): AutoLotto {
            val chance = money / 1000
            writeSingleOutput("$chance 개를 구매했습니다.")

            return AutoLotto(chance)
        }
    }
}

fun main() {
    val inputPrice = readPrice()
    val autoLotto = AutoLotto.play(inputPrice)

    val inputNumber = readNumbers()
    val winningTicket = autoLotto.getWinningTicket(inputNumber)

    writeROI(evaluateTotalPrize(autoLotto.tickets, winningTicket), inputPrice)
}
