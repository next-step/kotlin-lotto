package lotto.domain

enum class Match(val prize: Int, val lottoPrize: LottoPrize) {
    THREE(5000, object : LottoPrize {
        override fun isMatchPrize(matchResult: MatchResult): Boolean {
            return matchResult.count == 3
        }
    }),
    FOUR(50000, object : LottoPrize {
        override fun isMatchPrize(matchResult: MatchResult): Boolean {
            return matchResult.count == 4
        }
    }),
    FIVE(1500000, object : LottoPrize {
        override fun isMatchPrize(matchResult: MatchResult): Boolean {
            return matchResult.count == 5 && !matchResult.matchBonus
        }
    }),
    BONUS(30000000, object : LottoPrize {
        override fun isMatchPrize(matchResult: MatchResult): Boolean {
            return matchResult.count == 5 && matchResult.matchBonus
        }
    }),
    SIX(2000000000, object : LottoPrize {
        override fun isMatchPrize(matchResult: MatchResult): Boolean {
            return matchResult.count == 6
        }
    }),
    NONE(0, object : LottoPrize {
        override fun isMatchPrize(matchResult: MatchResult): Boolean {
            return false
        }
    });

    companion object {
        fun valueOf(count: Int, matchBonus: Boolean): Match {
            return values().find {
                it.lottoPrize.isMatchPrize(MatchResult(count, matchBonus))
            } ?: NONE
        }
    }
}
