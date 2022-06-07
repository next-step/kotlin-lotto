package lotto.service

import lotto.domain.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoServiceTest {

    @Test
    fun `로또 숫자를 입략받아 결과를 리턴해준다`() {
        val lottoService = LottoService()
        val nums = listOf(listOf(1, 2, 3, 4, 5, 7))
        val winNums = listOf(1, 2, 3, 4, 5, 6)

        lottoService.getLottoRanks(nums, winNums)
    }

    @Test
    fun `수익률을 계산한다`() {
        val invest = 1000.0
        val ranks = listOf(Rank.FOURTH)

        val lottoService = LottoService()
        val revenueRate = lottoService.getRevenueRate(invest, ranks)

        assertThat(revenueRate).isEqualTo(5.0)
    }
}
