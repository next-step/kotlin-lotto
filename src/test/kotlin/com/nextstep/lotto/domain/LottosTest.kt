package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottosTest {
    @Test
    fun `금액이 1000원 미만이면 로또 구매가 불가능하다`() {
        assertThrows<IllegalArgumentException> {
            Lottos.buyLotto(500)
        }
    }

    @Test
    fun `금액에 맞게 로또를 구매한다`() {
        val lottos = Lottos.buyLotto(10000)

        assertThat(lottos.lottos.size).isEqualTo(10)
    }
}
