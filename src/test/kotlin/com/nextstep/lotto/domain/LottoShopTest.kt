package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoShopTest {

    @Test
    fun `금액에 맞게 자동 로또를 구매한다`() {
        val lottos = LottoShop.buyAutoLotto(Money(10000))

        assertThat(lottos.size).isEqualTo(10)
    }

    @Test
    fun `수동 로또를 생성한다`() {
        val lotto = LottoShop.drawManualLotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto.lottoNumbers.filter { it.isMatched(1) }).isNotEmpty
    }

    @Test
    fun `당첨 로또를 생성한다`() {
        val winningLotto = LottoShop.drawWinningLotto(listOf(1, 2, 3, 4, 5, 6), 10)

        assertThat(winningLotto.winningLotto.lottoNumbers.filter { it.isMatched(1) }).isNotEmpty
        assertThat(winningLotto.bonusNumber).isEqualTo(LottoNumbers.valueOf(10))
    }

    @Test
    fun `돈이 부족하다면 에러`() {
        assertThrows<IllegalArgumentException> {
            LottoShop.checkBuy(Money(1000), 2)
        }
    }
}
