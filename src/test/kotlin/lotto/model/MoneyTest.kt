package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MoneyTest {
    @DisplayName(value = "로또를 구매할 수 없는 돈인 경우")
    @Test
    fun checkMoney() {
        assertThat(Money(900).canBuyLotto(MINIMUM_LOTTO_COUNT)).isEqualTo(false)
        assertThat(Money(2000).canBuyLotto(MINIMUM_LOTTO_COUNT)).isEqualTo(true)
        assertThat(Money(4900).canBuyLotto(5)).isEqualTo(false)
    }

    @DisplayName(value = "돈을 수동 로또로 소비한 후 남은 돈으로 자동 로또를 구매하는 경우")
    @Test
    fun checkAutoLottoMoney() {
        assertThat(Money(4000).spend(3).canBuyLotto(1)).isEqualTo(true)
        assertThat(Money(4000).spend(3).canBuyLotto(3)).isEqualTo(false)
    }
}
