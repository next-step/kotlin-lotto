package lotto

import lotto.domain.LottoResult
import lotto.domain.Money
import lotto.domain.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultTest {

    @DisplayName(value = "LottoResult를 통해 수익률을 계산할 수 있다.")
    @Test
    fun `LottoResult를 통해 수익률을 계산할 수 있다`() {
        val result = listOf(Rank.SECOND to 3, Rank.THIRD to 2).toMap() // 9300만원
        val lottoResult = LottoResult.of(result)

        val money = Money.from("9300000") // 930만원

        assertThat(lottoResult.getProfit(money)).isEqualTo(10.0f)
    }
}
