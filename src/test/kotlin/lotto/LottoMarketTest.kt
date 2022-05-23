package lotto

import lotto.domain.LottoMarket
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMarketTest {
    @ParameterizedTest
    @CsvSource(value = ["14000,14", "14500,14", "1000, 1", "500, 0"])
    fun `금액을 입력하면 로또를 몇 장 살수 있는지 알 수 있다`(price: Int, expect: Int) {
        Assertions.assertThat(LottoMarket.lottoAmount(price)).isEqualTo(expect)
    }
}
