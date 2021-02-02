package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinningLottoTest {

    @Test
    fun `LottoNumber가 매치하는 수량을 리턴해준다`() {
        val lotto = UserLotto((1..6).map { LottoNumber(it) })
        val winningLotto = WinningLotto.generate(listOf(5, 6, 7, 8, 9, 10))

        assertThat(winningLotto.findNumberOfMatch(lotto)).isEqualTo(2)
    }
}
