package lotto.domain

class MatchInfo(
    private val _matchInfo: MutableMap<Reward, Int> = Reward.values().associateWith { 0 }.toMutableMap()
) {
    val matchInfo: MutableMap<Reward, Int>
        get() = _matchInfo

    fun getRevenueFee() = matchInfo.map { it.key.reward * it.value }.sum()

    fun getRevenueRate(money: Money) = getRevenueFee() / money.getPurchaseFee().toDouble()

    private fun changeMatchInfo(reward: Reward) {
        _matchInfo[reward] = (_matchInfo[reward] ?: 0) + 1
    }

    fun checkNumberMatch(tickets: IssuanceTickets, numbers: Numbers, bonusNumber: BonusNumber) = also {
        tickets.tickets.forEach { ticket ->
            Reward.find(ticket, numbers, bonusNumber)
                ?.also { reward -> changeMatchInfo(reward) }
        }
    }
}
