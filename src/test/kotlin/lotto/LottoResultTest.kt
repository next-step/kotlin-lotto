package lotto

import lotto.domain.Grade
import lotto.domain.LottoResult
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `구입한 로또의 개수를 리턴한다`() {
        val result = LottoResult(listOf(Grade.First, Grade.Second, Grade.None))
        Assertions.assertThat(result.totalLottoCount).isEqualTo(3)
    }

    @Test
    fun `당첨된 로또의 상금 합을 구한다`() {
        val result = LottoResult(listOf(Grade.First, Grade.Second))
        val expect = Grade.First.reward + Grade.Second.reward
        Assertions.assertThat(result.totalReward).isEqualTo(expect)
    }

    @Test
    fun `당첨된 로또의 수익률을 구한다`() {
        val result = LottoResult(listOf(Grade.Fourth, Grade.Fourth))
        val lottoCost = 1000
        val expect = (Grade.Fourth.reward * 2) / (lottoCost * 2f)
        Assertions.assertThat(result.revenueRate).isEqualTo(expect)
    }
}
