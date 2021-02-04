package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PrizeTest {
    @Test
    fun `3개 일치하면 5000`() {
        assertThat(Prize.findPrize(3)).isEqualTo(Prize.THREE)
    }

    @Test
    fun `4개 일치하면 FOUR`() {
        assertThat(Prize.findPrize(4)).isEqualTo(Prize.FOUR)
    }

    @Test
    fun `5개 일치하면 FIVE`() {
        assertThat(Prize.findPrize(5)).isEqualTo(Prize.FIVE)
    }

    @Test
    fun `6개 일치하면 SIX`() {
        assertThat(Prize.findPrize(6)).isEqualTo(Prize.SIX)
    }

    @Test
    fun `3개 미만 일치하면 NONE`() {
        assertThat(Prize.findPrize(2)).isEqualTo(Prize.NONE)
    }
}
