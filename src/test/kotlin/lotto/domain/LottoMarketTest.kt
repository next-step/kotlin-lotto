package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMarketTest {
    @ParameterizedTest
    @CsvSource(value = ["14000,14", "14500,14", "1000, 1", "500, 0"])
    fun `금액을 입력하면 로또를 몇 장 살수 있는지 알 수 있다`(price: Int, expect: Int) {
        assertThat(LottoMarket.lottoAmount(price)).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["14000,14", "14500,14", "1000, 1", "500, 0"])
    fun `마켓에서 금액만큼 로또를 살 수 있다`(price: Int, expect: Int) {
        assertThat(LottoMarket.buy(price).size).isEqualTo(expect)
    }
}
