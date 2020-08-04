package com.nextstep.stringcalculator.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegerUtilKtTest {
    @Test
    fun `음수라면 true`() {
        assertThat((-1).isNegative()).isTrue()
    }

    @Test
    fun `음수가 아니라면 false`() {
        assertThat(1.isNegative()).isFalse()
    }
}
