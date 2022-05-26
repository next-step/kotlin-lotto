package lotto.domain

enum class Rank(val numberOfCorrect: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    operator fun component1() = numberOfCorrect
    operator fun component2() = winningMoney

    companion object {
        fun find(numberOfCorrect: Int): Rank {
            return if (numberOfCorrect > 2) {
                values().find { it.numberOfCorrect == numberOfCorrect }
                    ?: throw IllegalArgumentException("잘못된 rank 입니다.")
            } else {
                MISS
            }
        }
    }
}
