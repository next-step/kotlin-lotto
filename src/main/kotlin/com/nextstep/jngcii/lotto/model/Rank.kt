package com.nextstep.jngcii.lotto.model

enum class Rank(val count: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    companion object {
        private const val EXCEED_COUNT = 7

        fun of(count: Int): Rank? {
            require(count < EXCEED_COUNT) { "${EXCEED_COUNT}개 이상 일치할수는 없습니다." }

            return values().find { it.count == count }
        }
    }
}
