package lotto.domain

class Winner(private val numbers: Numbers) {

    constructor(expression: String) : this(Numbers(expression.split(",").map { it.toInt() }))

    fun getWinnerNumbers() = this.numbers

    fun checkNumberMatch(tickets: IssuanceTickets) = MatchInfo.checkWinner(tickets, numbers)
}
