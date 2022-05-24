package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoSellerTest {
    private lateinit var lottoSeller: LottoSeller

    @BeforeEach
    fun setUp() {
        lottoSeller = LottoSeller()
    }

    @ParameterizedTest
    @CsvSource("1000,1", "22000,22", "5500,5")
    fun `1000원당 1장의 로또를 구매한다`(money: Int, lottoCount: Int) {
        Assertions.assertThat(lottoSeller.purchaseLotto(money)).isEqualTo(lottoCount)
    }
}
