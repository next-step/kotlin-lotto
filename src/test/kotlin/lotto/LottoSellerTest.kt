package lotto

import lotto.domain.LottoSeller
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoSellerTest {
    @Test
    fun `로또 구매 갯수는 구매금액을 한장 가격으로 나눈 값이다`() {
        val lottoSeller = LottoSeller()
        assertThat(lottoSeller.getLottoPurchaseCount(5_000)).isEqualTo(5)
    }

    @Test
    fun sellLottosTest() {
        val lottoSeller = LottoSeller { listOf(1, 2, 3, 4, 5, 6) }
        val lottos = lottoSeller.sellLottos(5_000)
        lottos.lottos.forEach { assertThat(it.numbers).containsExactly(1, 2, 3, 4, 5, 6) }
    }
}
