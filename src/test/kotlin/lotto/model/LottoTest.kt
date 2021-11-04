package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {

    @DisplayName("로또의 가격은 0보다 작을 수 없다.")
    @Test
    fun lottoPrice() {
        val actual = LottoCreator.random(price = -5000).price
        assertThat(actual.value).isZero
    }
}
