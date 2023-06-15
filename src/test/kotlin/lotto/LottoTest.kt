package lotto

import lotto.domain.Lotto
import lotto.domain.LottoPurchase
import lotto.domain.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @Test
    fun `로또를 구입할 수 있다`() {
        assertThat(LottoPurchase().purchaseAuto(1)[0]).isInstanceOf(Lotto::class.java)
    }

    @ParameterizedTest
    @ValueSource(ints = [3000, 4000])
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 개수를 알 수 있다`(budget: Int) {
        assertThat(LottoPurchase.affordableLottoCount(budget)).isEqualTo(budget / LottoPurchase.DEFAULT_PRICE)
    }

    @Test
    fun `로또 1장의 가격은 1000원이다`() {
        assertThat(LottoPurchase.DEFAULT_PRICE).isEqualTo(1000)
    }

    @Test
    fun `지난 주 당첨 번호와 몇 개가 일치하는지 확인할 수 있다`() {
        assertThat(WinningLotto(listOf(1, 2, 3, 4, 5, 6)).checkEqualCount(listOf(2, 3, 4, 5, 6, 7))).isEqualTo(5)
    }
}
