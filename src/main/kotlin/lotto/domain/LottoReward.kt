package lotto.domain

enum class LottoReward(val matchCount: Int) {
    FIRST(6) {
        override val reward: Int = 2_000_000_000
    },
    SECOND(5) {
        override val reward: Int = 30_000_000
    },
    THIRD(5) {
        override val reward: Int = 1_500_000
    },
    FIRTH(4) {
        override val reward: Int = 50_000
    },
    FIFTH(3) {
        override val reward: Int = 5000
    },
    FAIL(0) {
        override val reward: Int = 0
    }
    ;
    abstract val reward: Int

    companion object {
        fun from(matchCount: Int, bonusFlag: Boolean): LottoReward {
            if (matchCount == 5 && !bonusFlag) return THIRD

            return values().firstOrNull { it.matchCount == matchCount } ?: FAIL
        }
    }
}
