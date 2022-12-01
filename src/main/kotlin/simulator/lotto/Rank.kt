package simulator.lotto

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000) {
        override fun matches(countOfMatch: Int, matchBonus: Boolean): Boolean {
            return countOfMatch == this.countOfMatch
        }
    },
    SECOND(5, 30_000_000) {
        override fun matches(countOfMatch: Int, matchBonus: Boolean): Boolean {
            return countOfMatch == this.countOfMatch && matchBonus
        }
    },
    THIRD(5, 1_500_000) {
        override fun matches(countOfMatch: Int, matchBonus: Boolean): Boolean {
            return countOfMatch == this.countOfMatch && matchBonus == false
        }
    },
    FOURTH(4, 50_000) {
        override fun matches(countOfMatch: Int, matchBonus: Boolean): Boolean {
            return countOfMatch == this.countOfMatch
        }
    },
    FIFTH(3, 5_000) {
        override fun matches(countOfMatch: Int, matchBonus: Boolean): Boolean {
            return countOfMatch == this.countOfMatch
        }
    },
    MISS(0, 0) {
        override fun matches(countOfMatch: Int, matchBonus: Boolean): Boolean {
            return countOfMatch == this.countOfMatch
        }
    };

    abstract fun matches(countOfMatch: Int, matchBonus: Boolean): Boolean

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank {
            return values().find {
                it.matches(countOfMatch, matchBonus)
            } ?: MISS
        }
    }
}