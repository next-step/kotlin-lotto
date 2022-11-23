package simulator.lotto

import simulator.lotto.Rank.*

enum class Rank {
    FIRST {
        override fun prize(): Int {
            return FIRST_PRIZE
        }
    },

    SECOND {
        override fun prize(): Int {
            return SECOND_PRIZE
        }
    },

    THIRD {
        override fun prize(): Int {
            return THIRD_PRIZE
        }
    },

    FOURTH {
        override fun prize(): Int {
            return FOURTH_PRIZE
        }
    };

    abstract fun prize(): Int

    companion object {
        private const val FIRST_PRIZE = 2_000_000_000
        private const val SECOND_PRIZE = 1_500_000
        private const val THIRD_PRIZE = 50_000
        private const val FOURTH_PRIZE = 5_000

        private const val LOTTO_FIRST_RANK_MATCHES = 6
        private const val LOTTO_SECOND_RANK_MATCHES = 5
        private const val LOTTO_THIRD_RANK_MATCHES = 4
        private const val LOTTO_FOURTH_RANK_MATCHES = 3

        fun match(lottoNumberMatches: Int): Rank? {
            return when (lottoNumberMatches) {
                LOTTO_FIRST_RANK_MATCHES -> FIRST
                LOTTO_SECOND_RANK_MATCHES -> SECOND
                LOTTO_THIRD_RANK_MATCHES -> THIRD
                LOTTO_FOURTH_RANK_MATCHES -> FOURTH
                else -> null
            }
        }
    }
}