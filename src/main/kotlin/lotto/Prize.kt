package lotto

sealed class Prize {

    abstract val money: Int

    object First : Prize() {
        override val money: Int = 2_000_000_000
    }

    object Second : Prize() {
        override val money: Int = 1_500_000
    }

    object Third : Prize() {
        override val money: Int = 50_000
    }

    object Fourth : Prize() {
        override val money: Int = 5_000
    }

    object None : Prize() {
        override val money: Int = 0
    }

    companion object {
        fun from(count: Int): Prize {
            return when (count) {
                6 -> First
                5 -> Second
                4 -> Third
                3 -> Fourth
                else -> None
            }
        }
    }

}
