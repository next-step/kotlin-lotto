package com.nextstep.stringcalculator.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class IntegerUtilKtTest {
    @ParameterizedTest
    @ValueSource(ints = [-1])
    fun `음수라면 true`(intValue: Int) {
        assertThat((intValue).isNegative()).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [1])
    fun `음수가 아니라면 false`(intValue: Int) {
        assertThat(intValue.isNegative()).isFalse()
    }
}
