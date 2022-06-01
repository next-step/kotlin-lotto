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
    fun `돈의 단위가 1000이 아닌 경우 예외처리를 한다`() {
        assertThatIllegalArgumentException()
            .isThrownBy { LottoSeller(Money(BigDecimal(1_250))) }
    }

    @Test
    fun `수동으로 로또를 구매후 남은 잔금 확인`() {
        val lottoSeller = LottoSeller(Money(BigDecimal(14_000)))
        lottoSeller.buyManual(4)
        assertThat(lottoSeller.getLottoCount()).isEqualTo(10)
    }

    @Test
    fun `가지고 있는 금액보다 초과된 수동 로또 갯수를 입력 시 예외 처리를 한다`() {
        val lottoSeller = LottoSeller(Money(BigDecimal(14_000)))
        assertThatIllegalArgumentException()
            .isThrownBy { lottoSeller.buyManual(15) }
    }
}
