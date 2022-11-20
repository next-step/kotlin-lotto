package lotto.domain

import kotlin.math.floor

class LottoStatistics(private val matchesCountResult: List<Int>, private val amount: Int) {
    var firstPlace: Int = 0
        private set
    var secondPlace: Int = 0
        private set
    var thirdPlace: Int = 0
        private set
    var lastPlace: Int = 0
        private set
    var notingPlace: Int = 0
        private set

    var rateOfReward: Double = 0.0
        private set

    init {
        matchesCountResult.map { matchesCount ->
            when (matchesCount) {
                LottoRule.FIRST_PLACE.matchesCount -> firstPlace++
                LottoRule.SECOND_PLACE.matchesCount -> secondPlace++
                LottoRule.THIRD_PLACE.matchesCount -> thirdPlace++
                LottoRule.LAST_PLACE.matchesCount -> lastPlace++
                else -> notingPlace++
            }
        }

        rateOfReward = calculateTotalPofit()
    }

    private fun calculateTotalPofit(): Double {
        var reward = 0.0
        LottoRule.values().map { rule ->
            when (rule.name) {
                "FIRST_PLACE" -> reward += LottoRule.FIRST_PLACE.getTotalReward(firstPlace)
                "SECOND_PLACE" -> reward += LottoRule.SECOND_PLACE.getTotalReward(secondPlace)
                "THIRD_PLACE" -> reward += LottoRule.THIRD_PLACE.getTotalReward(thirdPlace)
                "LAST_PLACE" -> reward += LottoRule.LAST_PLACE.getTotalReward(lastPlace)
            }
        }
        println("amount / reward")
        println(reward)
        return floor(reward / amount * 100) / 100
    }
}
