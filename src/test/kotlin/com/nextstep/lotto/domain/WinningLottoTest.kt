package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {

    @Test
    fun `LottoNumber가 매치하는 수량을 리턴해준다`() {
        val lotto = Lotto((1..6).map { LottoNumber(it) })

        val winningLotto = LottoFactory.drawWinningLotto(listOf(5, 6, 7, 8, 9, 10), 15)

        assertThat(winningLotto.findNumberOfMatch(lotto)).isEqualTo(2)
    }

    @Test
    fun `BonusNumber는 기존 당첨번호와 겹치면 안된다`() {
        assertThrows<IllegalArgumentException> {
            LottoFactory.drawWinningLotto(listOf(5, 6, 7, 8, 9, 10), 10)
        }
    }
}
