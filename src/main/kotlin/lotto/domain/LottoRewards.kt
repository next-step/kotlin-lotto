package lotto.domain

data class LottoRewards(
    private val rewards: List<LottoReward>
) {

    fun exchange(): Cash {
        val money = rewards.fold(0) { total, current ->
            total + current.reward
        }
        return Cash(money)
    }

    override fun toString(): String {
        val grouped = rewards.groupBy { it }
        return """
            3개 일치 (5000원)- ${grouped[LottoReward.FIRTH]?.size ?: 0}개
            4개 일치 (50000원)- ${grouped[LottoReward.THIRD]?.size ?: 0}개
            5개 일치 (1500000원)- ${grouped[LottoReward.SECOND]?.size ?: 0}개
            6개 일치 (2000000000원)- ${grouped[LottoReward.FIRST]?.size ?: 0}개
        """.trimIndent()
    }
}
