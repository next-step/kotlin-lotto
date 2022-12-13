package lotto.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class LottoShopTest {
    @Test
    internal fun `N*1000원을 입력하면 N개가 발급된다`() {
        val lottos = LottoShop.buy(BigDecimal(5999))
        assertThat(lottos.size).isEqualTo(5)
    }

    @Test
    internal fun `1000원 미만 금액이 들어오면 RuntimeException`() {
        assertThrows<IllegalArgumentException> { LottoShop.buy(BigDecimal(999)) }
    }
}
