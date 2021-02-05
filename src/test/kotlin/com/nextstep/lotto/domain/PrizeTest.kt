package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PrizeTest {
    @Test
    fun `3개 일치하면 5등`() {
        assertThat(Prize.findPrize(MatchResult(3, false))).isEqualTo(Prize.FIFTH)
    }

    @Test
    fun `4개 일치하면 4등`() {
        assertThat(Prize.findPrize(MatchResult(4, false))).isEqualTo(Prize.FOURTH)
    }

    @Test
    fun `5개 일치하고 보너스가 일치하지 않는다면 3등`() {
        assertThat(Prize.findPrize(MatchResult(5, false))).isEqualTo(Prize.THIRD)
    }

    @Test
    fun `5개 일치하고 보너스도 일치하다면 2등`() {
        assertThat(Prize.findPrize(MatchResult(5, false))).isEqualTo(Prize.THIRD)
    }

    @Test
    fun `6개 일치하면 1등`() {
        assertThat(Prize.findPrize(MatchResult(6, false))).isEqualTo(Prize.FIRST)
    }

    @Test
    fun `3개 미만 일치하면 NONE`() {
        assertThat(Prize.findPrize(MatchResult(2, false))).isEqualTo(Prize.NONE)
    }
}
