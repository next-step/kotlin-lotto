package com.nextstep.second.lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoResultVoTest {
    @Test
    fun `공통된 숫자가 3개인 경우`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winnerLotto = Lotto(listOf(1, 2, 3, 8, 9, 45))

        // when
        val result: LottoResultVo = LottoResultVo(winnerLotto, lotto)

        result.sameNumberCount shouldBe 3
    }

    @Test
    fun `공통된 숫자가 5개인 경우`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winnerLotto = Lotto(listOf(1, 2, 3, 4, 5, 45))

        // when
        val result: LottoResultVo = LottoResultVo(winnerLotto, lotto)

        // then
        result.sameNumberCount shouldBe 5
    }
}
