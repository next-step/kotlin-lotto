package lotto.domain

data class Record private constructor(
    val matchCount: Int,
    val reward: Int,
) {
    init {
        require(reward >= 0) {
            "각 등수별 당첨금액은 0이하 일 수 없습니다."
        }
    }

    var recordCount: Int = 0
        private set

    fun addCountByRecord(matchCount: Int) {
        if (this.matchCount == matchCount) {
            recordCount++
        }
    }

    fun totalReward(): Int {
        return reward * recordCount
    }

    companion object {

        fun of(
            matchCount: Int,
            reward: Int,
        ): Record = Record(
            matchCount,
            reward
        )
    }
}
