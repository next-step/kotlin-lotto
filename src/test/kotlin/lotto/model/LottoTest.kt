package lotto.model

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @DisplayName("로또의 가격이 0보다 작으면 RuntimeException 예외가 발생해야 한다.")
    @Test
    fun lottoPrice() {
        assertThrows<RuntimeException> {
            LottoCreator.random(price = -5000)
        }
    }
}
