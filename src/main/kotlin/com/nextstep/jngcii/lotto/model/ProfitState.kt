package com.nextstep.jngcii.lotto.model

enum class ProfitState(
    val phase: String,
    private val state: Int
) {
    PROFIT("이익", 1),
    ORIGIN("본전", 0),
    LOSS("손해", -1);

    companion object {
        const val ORIGIN_POINT = 1

        fun of(state: Int) = values()
            .find { it.state == state }
            ?: throw IllegalArgumentException("잘못된 state 입니다.")

        fun of(rewardYield: Double): ProfitState {
            val state = rewardYield.compareTo(ORIGIN_POINT)
            return of(state)
        }
    }
}
