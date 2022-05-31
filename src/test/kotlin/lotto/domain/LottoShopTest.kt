package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoShopTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 100])
    fun `수량을 주면 수량만큼 자동 로또를 구매한다`(numberOfLottos: Int) {
        Assertions.assertThat(LottoShop().purchase(numberOfLottos).lottoList.size)
            .isEqualTo(numberOfLottos)
    }

    @Test
    fun `구입 가능 로또 수를 반화한다`() {
        Assertions.assertThat(LottoShop.getAvailableNumberOfLotto(Payment(1000))).isEqualTo(1)
        Assertions.assertThat(LottoShop.getAvailableNumberOfLotto(Payment(9999))).isEqualTo(9)
    }
}
