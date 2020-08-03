package com.nextstep.stringcalculator.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegerUtilKtTest {
    @Test
    fun `자연수가 맞다면 true`() {
        assertThat(1.isNatural()).isTrue()
    }

    @Test
    fun `자연수가 아니라면 false`() {
        assertThat((-1).isNatural()).isFalse()
    }
}
