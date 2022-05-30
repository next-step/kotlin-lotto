package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoVendorTest {
    @ParameterizedTest
    @CsvSource(value = ["1000, 1", "1200, 1", "15_000,15"])
    fun `로또 구매 금액만큼 로또를 발급한다`(price: Int, expect: Int) {
        val lottoPrice = Price(price)
        assertThat(LottoVendor().sellLotto(lottoPrice).size).isEqualTo(expect)
    }
}
