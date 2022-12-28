package lotto.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class LottoShopTest {
    @Test
    internal fun `N*1000원을 입력하면 N개가 발급된다`() {
        val lottos = LottoShop.buyLottos(BigDecimal(5999))
        assertThat(lottos.size).isEqualTo(5)
    }

    @Test
    internal fun `1000원 미만 금액이 들어오면 RuntimeException`() {
        assertThrows<IllegalArgumentException> { LottoShop.buyLottos(BigDecimal(999)) }
    }

    @Test
    internal fun `수동로또를 사고 나머지 금액은 자동로또를 산다`() {
        val money = BigDecimal(5000)
        val lottoNumbers = listOf("1,2,3,4,5,6", "2,3,4,5,6,7")

        val lottos = LottoShop.buyLottos(money, lottoNumbers)
        assertThat(lottos.size).isEqualTo(5)
    }

    @Test
    internal fun `모든 로또를 수동으로 구매한다`() {
        val money = BigDecimal(2000)
        val lottoNumbers = listOf("1,2,3,4,5,6", "2,3,4,5,6,7")

        val lottos = LottoShop.buyLottos(money, lottoNumbers)
        assertThat(lottos.size).isEqualTo(2)
    }

    @Test
    internal fun `금액보다 많은 수동로또를 사려하면 RuntimeException`() {
        val money = BigDecimal(1999)
        val lottoNumbers = listOf("1,2,3,4,5,6", "2,3,4,5,6,7")

        assertThrows<IllegalArgumentException> { LottoShop.buyLottos(money, lottoNumbers) }
    }
}
