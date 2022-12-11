package lotto.domain

class MatchInfo(val matchInfo: MutableMap<Reward, Int> = Reward.values().associateWith { 0 }.toMutableMap()) {
    fun getRevenueFee() = matchInfo.map { it.key.reward * it.value }.sum()
}
