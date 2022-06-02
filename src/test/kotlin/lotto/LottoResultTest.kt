package lotto

import lotto.domain.Grade
import lotto.domain.LottoResult
import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `당첨된 로또의 상금 합을 구한다`() {
        val result = LottoResult(Money(0), listOf(Grade.First, Grade.Second))
        val expect = Grade.First.reward + Grade.Second.reward
        Assertions.assertThat(result.totalReward).isEqualTo(expect)
    }

    @Test
    fun `당첨된 로또의 수익률을 구한다`() {
        val result = LottoResult(Money(5000), listOf(Grade.Fourth, Grade.Fourth))
        val expect = (Grade.Fourth.reward * 2) / 5000f
        Assertions.assertThat(result.revenueRate).isEqualTo(expect)
    }
}
