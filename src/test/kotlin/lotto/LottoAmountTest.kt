package lotto

import lotto.domain.LottoAmount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoAmountTest {

    @Test
    fun `로또 구입 금액을 입력받을 수 있다`() {
        val lottoAmount: LottoAmount = LottoAmount(1000)

        assertThat(lottoAmount).isNotNull
    }

    @Test
    fun `구입 금액에 따른 로또 개수를 반환한다`() {
        val lottoAmount: LottoAmount = LottoAmount(10000)

        val lottoCount: Int = lottoAmount.getLottoCount()

        assertThat(lottoCount).isEqualTo(10)
    }

    @Test
    fun `로또 구입 금액보다 많은 로또를 구매하려 한다면 예외를 발생시킨다`() {
        val lottoAmount: LottoAmount = LottoAmount(1000)

        assertThrows<IllegalArgumentException> {
            lottoAmount.processPayment(2)
        }
    }
}
