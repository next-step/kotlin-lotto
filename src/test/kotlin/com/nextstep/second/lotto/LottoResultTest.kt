package com.nextstep.second.lotto

import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoResult
import com.nextstep.second.lotto.domain.LottoReward
import com.nextstep.second.lotto.domain.WinnerLotto
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `공통된 숫자가 3개인 경우`() {
        // given
        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val lottoList = listOf(lotto)
        val winnerLotto = WinnerLotto.of(listOf(1, 2, 3, 8, 9, 45), 7)

        // when
        val result: LottoResult = LottoResult.of(winnerLotto, lottoList)

        result.getMatchedNumberCount(LottoReward.THIRD) shouldBe 1
    }

    @Test
    fun `공통된 숫자가 5개인 경우`() {
        // given
        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val lottoList = listOf(lotto)
        val winnerLotto = WinnerLotto.of(listOf(1, 2, 3, 4, 5, 45), 7)

        // when
        val result: LottoResult = LottoResult.of(winnerLotto, lottoList)

        // then
        result.getMatchedNumberCount(LottoReward.FIFTH) shouldBe 1
    }

    @Test
    fun `공통된 숫자가 5개이고, 보너스 볼이 일치하는 경우`() {
        // given
        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val lottoList = listOf(lotto)
        val winnerLotto = WinnerLotto.of(listOf(1, 2, 3, 4, 5, 45), 6)

        // when
        val result: LottoResult = LottoResult.of(winnerLotto, lottoList)

        // then
        result.getMatchedNumberCount(LottoReward.FIFTH_BONUS) shouldBe 1
    }
}
