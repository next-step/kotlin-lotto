package lotto.domain

class Winner(private val numbers: Numbers, private val bonusNumber: BonusNumber) {

    constructor(issuesNumbers: String, bonusNumber: String) :
            this(Numbers(issuesNumbers.split(",").map { it.toInt() }), BonusNumber(bonusNumber.toInt()))

    fun checkNumberMatch(tickets: IssuanceTickets) = MatchInfo().checkNumberMatch(tickets, numbers, bonusNumber)
}
