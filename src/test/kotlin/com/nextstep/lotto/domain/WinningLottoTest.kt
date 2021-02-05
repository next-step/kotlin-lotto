package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {

    @Test
    fun `보너스 매칭 정보가 포함된 결과를 리턴해준다`() {
        val lotto = Lotto((1..6).map { LottoNumber(it) })

        val winningLotto = LottoShop.drawWinningLotto(listOf(5, 6, 7, 8, 9, 10), 3)

        val matchResult = winningLotto.getMatchResult(lotto)
        assertThat(matchResult.numberOfMatch).isEqualTo(2)
        assertThat(matchResult.matchBonus).isTrue()
    }

    @Test
    fun `BonusNumber는 기존 당첨번호와 겹치면 안된다`() {
        assertThrows<IllegalArgumentException> {
            LottoShop.drawWinningLotto(listOf(5, 6, 7, 8, 9, 10), 10)
        }
    }
}
