package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoFactoryTest {
    @Test
    fun `수동 로또를 생성한다`() {
        val lotto = LottoFactory.drawManualLotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto.lottoNumbers.filter { it.isMatched(1) }).isNotEmpty
    }
}
