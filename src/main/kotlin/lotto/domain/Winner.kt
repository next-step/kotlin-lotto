package lotto.domain

class Winner(private val numbers: Numbers) {

    constructor(issuesNumbers: String, bonusNumber: String) :
            this(Numbers(issuesNumbers.split(",").map { it.toInt() }, bonusNumber.toInt()))

    fun checkNumberMatch(tickets: IssuanceTickets) = MatchInfo.checkWinner(tickets, numbers)
}
