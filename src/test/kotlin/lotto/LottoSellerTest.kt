package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoSellerTest {
    @ParameterizedTest
    @CsvSource("1000,1", "22000,22", "5500,5")
    fun `1000원당 1장의 로또를 구매한다`(money: Int, lottoCount: Int) {
        assertThat(LottoSeller.enableSellLottoCount(money)).isEqualTo(lottoCount)
    }

    @ParameterizedTest
    @CsvSource("1000,1", "22000,22", "5500,5")
    fun `로또를 구매한 만큼 로또가 발행된다`(enablePurchaseLottoCount: Int, lottoCount: Int) {
        val lottos = LottoSeller.sellLotto(enablePurchaseLottoCount)
        assertThat(lottos.size).isEqualTo(lottoCount)
    }
}
