package lotto

import lotto.domain.LottoSeller
import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoSellerTest {

    @Test
    fun `구매금액만큼 로또를 발급한다`() {
        val lotto = LottoSeller.buy(Money(11500))
        val expected = 11
        Assertions.assertThat(lotto.size).isEqualTo(expected)
    }
}
