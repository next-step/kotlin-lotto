package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BuyerTest {
    private lateinit var buyer: Buyer

    @BeforeEach
    fun beforeTest() {
        buyer = Buyer()
    }

    @DisplayName(value = "금액에 따라 구입 가능한 로또의 수를 산출한다.")
    @Test
    fun buyLottoCount() {
        assertThatThrownBy { buyer.buyLotto(900).size }.isInstanceOf(IllegalArgumentException::class.java)
        assertThat(buyer.buyLotto(5000).size).isSameAs(5)
        assertThat(buyer.buyLotto(14600).size).isSameAs(14)
    }
}
