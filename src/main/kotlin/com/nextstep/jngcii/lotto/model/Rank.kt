package com.nextstep.jngcii.lotto.model

enum class Rank(val count: Int, val price: Int) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    val isSecond get() = this == SECOND

    companion object {
        private const val EXCEED_COUNT = 7

        fun of(count: Int, bonusMatch: Boolean): Rank? {
            require(count < EXCEED_COUNT) { "${EXCEED_COUNT}개 이상 일치할수는 없습니다." }

            return if (count == 5) {
                if (bonusMatch) SECOND else THIRD
            } else {
                values().find { it.count == count }
            }
        }
    }
}
