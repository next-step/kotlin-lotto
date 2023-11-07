package lotto.domain

enum class LottoPrize {
    FIRST {
        override fun getPrizeMoney(): Int {
            return 2000000000
        }
    },
    SECOND {
        override fun getPrizeMoney(): Int {
            return 1500000
        }
    },
    THIRD {
        override fun getPrizeMoney(): Int {
            return 50000
        }
    },
    FOURTH {
        override fun getPrizeMoney(): Int {
            return 5000
        }
    },
    MISS {
        override fun getPrizeMoney(): Int {
            return 0
        }
    };

    abstract fun getPrizeMoney(): Int

    companion object {
        fun of(matchCount: Int): LottoPrize {
            return when (matchCount) {
                6 -> FIRST
                5 -> SECOND
                4 -> THIRD
                3 -> FOURTH
                else -> MISS
            }
        }
    }
}
