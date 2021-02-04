package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoNumbersTest {
    @Test
    fun `6개의 랜덤 숫자를 shuffle하여 가져온다`() {
        assertThat(LottoNumbers.drawRandomNumbers().size).isEqualTo(6)
    }

    @Test
    fun `로또 숫자에 일치하지 않는 값을 찾으려 하면 에러를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers.valueOf(55)
        }
    }

    @Test
    fun `로또 숫자에 일치하는 LottoNumber를 가져온다`() {
        val lottoNumber = LottoNumbers.valueOf(40)

        assertThat(lottoNumber.isMatched(40)).isTrue()
    }
}
