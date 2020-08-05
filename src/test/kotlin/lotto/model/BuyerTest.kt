package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BuyerTest {
    @DisplayName(value = "금액에 따라 구입 가능한 로또의 수를 산출한다.")
    @Test
    fun buyLottoCount() {
        assertThatThrownBy { buyLotto(Money(900)).size }.isInstanceOf(IllegalArgumentException::class.java)
        assertThat(buyLotto(Money(5000)).size).isSameAs(5)
        assertThat(buyLotto(Money(14600)).size).isSameAs(14)
    }
}
