package com.nextstep.second.lotto

import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoResult
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `공통된 숫자가 3개인 경우`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoList = listOf(lotto)
        val winnerLotto = Lotto(listOf(1, 2, 3, 8, 9, 45))

        // when
        val result: LottoResult = LottoResult.of(winnerLotto, lottoList)

        result.getMatchedNumber(3) shouldBe 1
    }

    @Test
    fun `공통된 숫자가 5개인 경우`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoList = listOf(lotto)
        val winnerLotto = Lotto(listOf(1, 2, 3, 4, 5, 45))

        // when
        val result: LottoResult = LottoResult.of(winnerLotto, lottoList)

        // then
        result.getMatchedNumber(5) shouldBe 1
    }
}
