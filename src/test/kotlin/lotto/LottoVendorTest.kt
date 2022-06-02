package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoVendorTest {
    @ParameterizedTest
    @CsvSource(value = ["1000, 1", "1200, 1", "15_000,15"])
    fun `로또 구매 금액만큼 로또를 발급한다`(price: Int, expect: Int) {
        val lottoPrice = Price(price)
        assertThat(LottoVendor().sellLotto(lottoPrice).lottos.size).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(ints = [999, 100])
    fun `로또 금액(1000원) 미만으로 살 수 있는 로또 개수 구하면 RuntimeException 발생`(amount: Int) {
        assertThatIllegalArgumentException().isThrownBy {
            LottoVendor().getCountOfLotto(Price(amount))
        }
    }
}
