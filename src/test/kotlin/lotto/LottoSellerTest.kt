package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class LottoSellerTest {

    @Test
    fun `Lotto금액별 갯수`() {
        val lottoSeller = LottoSeller(Money(BigDecimal(14000)))
        assertThat(lottoSeller.getLottoCount()).isEqualTo(14)
    }
}
