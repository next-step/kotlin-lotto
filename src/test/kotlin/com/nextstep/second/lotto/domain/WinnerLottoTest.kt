package com.nextstep.second.lotto.domain

import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinnerLottoTest {
    @Test
    fun `6자리 숫자와 1개 보너스 번호로 WinnerLotto 객체를 생성한다`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        // when
        val winnerLotto = WinnerLotto.of(lottoNumbers, bonusNumber)

        // then
        winnerLotto shouldNotBe null
    }

    @Test
    fun `6자리 숫자는 중복된 경우 예외`() {
        // given
        val lottoNumbers = listOf(1, 1, 3, 4, 5, 6)
        val bonusNumber = 7

        // when
        assertThrows<IllegalArgumentException> {
            val winnerLotto = WinnerLotto.of(lottoNumbers, bonusNumber)
        }
    }

    @Test
    fun `보너스 숫자는 당첨 번호 6자리와 중복된 경우 예외`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 1

        // when
        assertThrows<IllegalArgumentException> {
            val winnerLotto = WinnerLotto.of(lottoNumbers, bonusNumber)
        }
    }
}
