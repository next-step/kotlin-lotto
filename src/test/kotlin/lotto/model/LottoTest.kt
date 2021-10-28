package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {

    @DisplayName("로또의 가격은 1,000원이다.")
    @Test
    fun lottoPrice() {
        val numbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertThat(lotto.price).isEqualTo(1000)
    }
}
