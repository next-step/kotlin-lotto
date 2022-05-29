package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class LottoSellerTest {

    @Test
    fun `금액 별 로또의 갯수`() {
        val lottoSeller = LottoSeller(Money(BigDecimal(14_000)))
        assertThat(lottoSeller.getLottoCount()).isEqualTo(14)
    }

    @Test
    fun `돈의 단위가 1000이 아닌 경우 예외처리`() {
        assertThatIllegalArgumentException()
            .isThrownBy { LottoSeller(Money(BigDecimal(1_250))) }
    }
}
