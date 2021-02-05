package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {
    @Test
    fun `자동 로또의 개수를 리턴해준다`() {
        val money = Money(10000)
        val manualLottos = LottoFactory.buyManualLotto(money, listOf(listOf(1, 2, 3, 4, 5, 6)))
        val autoLottos = LottoFactory.buyAutoLotto(money)
        val lottos = Lottos(manualLottos, autoLottos)

        assertThat(lottos.getNumberOfAuto()).isEqualTo(9)
    }
}
