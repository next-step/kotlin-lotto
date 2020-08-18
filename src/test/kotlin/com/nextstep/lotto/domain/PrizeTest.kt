package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PrizeTest {
    @Test
    fun `3개 일치하면 5000`() {
        assertThat(Prize.findPrize(3)).isEqualTo(5000)
    }

    @Test
    fun `4개 일치하면 50000`() {
        assertThat(Prize.findPrize(4)).isEqualTo(50000)
    }

    @Test
    fun `5개 일치하면 1500000`() {
        assertThat(Prize.findPrize(5)).isEqualTo(1500000)
    }

    @Test
    fun `6개 일치하면 2000000000`() {
        assertThat(Prize.findPrize(6)).isEqualTo(2000000000)
    }

    @Test
    fun `3개 미만 일치하면 0`() {
        assertThat(Prize.findPrize(2)).isEqualTo(0)
    }
}
