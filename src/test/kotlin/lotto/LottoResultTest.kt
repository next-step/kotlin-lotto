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
        val result = listOf(Rank.FIRST to 3, Rank.SECOND to 2).toMap() // 900만원
        val lottoResult = LottoResult(result)

        val money = Money.from("10000000") // 1000만원

        assertThat(lottoResult.getProfit(money)).isEqualTo(0.9f)
    }
}
