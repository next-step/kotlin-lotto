package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoSellerTest {

    @Test
    fun `14_000원을 지불하면 14개의 로또를 얻어야 한다`() {
        // given
        val seller = LottoSeller(
            quantityChanger = QuantityChangerImpl(),
            lottoGenerator = LottoGeneratorImpl(),
        )

        // when
        val result = seller.purchase(14_000)

        // then
        assertThat(result.size).isEqualTo(14)
    }

}
