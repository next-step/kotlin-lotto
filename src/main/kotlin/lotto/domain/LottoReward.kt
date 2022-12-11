package lotto.domain

enum class LottoReward(val matches: Int) {
    FIRST(6) {
        override val reward: Int = 2_000_000_000
    },
    SECOND(5) {
        override val reward: Int = 1_500_000
    },
    THIRD(4) {
        override val reward: Int = 50_000
    },
    FIRTH(3) {
        override val reward: Int = 5000
    },
    FAIL(0) {
        override val reward: Int = 0
    }
    ;
    abstract val reward: Int

    companion object {
        fun from(matchCount: Int): LottoReward {
            return values().firstOrNull { it.matches == matchCount } ?: FAIL
        }
    }
}
