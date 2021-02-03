package com.nextstep.lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTest {
    @Test
    fun `로또 숫자 개수가 6개가 아니면 에러가 발생한다`() {
        val lottoNumbers: List<LottoNumber> = (1..5).map { LottoNumber(it) }

        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }
}
