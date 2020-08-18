package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 2])
    fun `로또 숫자가 1보다 작으면 에러`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [46, 47, 999])
    fun `로또 숫자가 45보다 크면 에러`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }
    }

    @Test
    fun `숫자와 LottoNumber가 일치하는지 확인한다`() {
        val lottoNumber = LottoNumber(10)

        assertThat(lottoNumber.isMatched(10)).isTrue()
    }
}
