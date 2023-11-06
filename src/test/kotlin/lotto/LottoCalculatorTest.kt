package lotto

import lotto.domain.LottoCalculator
import lotto.domain.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoCalculatorTest {

    @Test
    fun `로또 계산기를 생성할 수 있다`() {
        val lottoCalculator: LottoCalculator = LottoCalculator()

        assertThat(lottoCalculator).isNotNull
    }

    @ParameterizedTest
    @CsvSource("MISS,MISS,MISS,-1.0", "MISS,MISS,FOURTH,0.67", "FIRST,MISS,MISS,666665.67")
    fun `로또 계산기를 통해 수익률을 계산할 수 있다`(first: LottoRank, second: LottoRank, third: LottoRank, expected: Double) {
        val lottoCalculator: LottoCalculator = LottoCalculator()

        val lottoRankList: List<LottoRank> = listOf(first, second, third)
        val buyingPrice: Double = 3000.0

        val returnOnInvestment: Double = lottoCalculator.calculateReturnOnInvestment(lottoRankList, buyingPrice)

        assertThat(returnOnInvestment).isEqualTo(expected)
    }
}
