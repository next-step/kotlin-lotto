package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoFactoryTest {

    @Test
    fun `금액에 맞게 로또를 구매한다`() {
        val lottos = LottoFactory.buyLotto(10000)

        assertThat(lottos.size).isEqualTo(10)
    }

    @Test
    fun `수동 로또를 생성한다`() {
        val lotto = LottoFactory.drawManualLotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto.lottoNumbers.filter { it.isMatched(1) }).isNotEmpty
    }

    @Test
    fun `당첨 로또를 생성한다`() {
        val winningLotto = LottoFactory.drawWinningLotto(listOf(1, 2, 3, 4, 5, 6), 10)

        assertThat(winningLotto.winningLotto.lottoNumbers.filter { it.isMatched(1) }).isNotEmpty
        assertThat(winningLotto.bonusNumber).isEqualTo(LottoNumbers.valueOf(10))
    }
}
