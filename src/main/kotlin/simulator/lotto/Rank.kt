package simulator.lotto

enum class Rank {
    FIRST {
        override fun prize(): Int {
            return 2_000_000_000
        }

        override fun match(): Int {
           return 6
        }
    },

    SECOND {
        override fun prize(): Int {
            return 1_500_000
        }

        override fun match(): Int {
            return 5
        }
    },

    THIRD {
        override fun prize(): Int {
            return 50_000
        }

        override fun match(): Int {
            return 4
        }
    },

    FOURTH {
        override fun prize(): Int {
            return 5_000
        }

        override fun match(): Int {
            return 3
        }
    };

    abstract fun prize(): Int

    abstract fun match(): Int

    companion object {
        fun aggregate(matches: Int): Rank? {
            return values().find{it.match() == matches}
        }
    }
}