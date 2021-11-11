package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoGeneratorTest {

    @ParameterizedTest
    @CsvSource("1000,1", "5000,5", "10000,10")
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급한다`(paidPrice: Int, expectedCount: Int) {
        val lottos = LottoGenerator().generate(paidPrice = Money(paidPrice))
        assertThat(lottos).hasSize(expectedCount)
    }
}
