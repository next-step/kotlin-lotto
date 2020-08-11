package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoProgramTest {
    @DisplayName("구입한 금액 만큼의 로또 장수를 반환한다.")
    @Test
    fun `when input amountOfMoney then return amountOfLotto`() {
        assertThat(LottoProgram.getAmountOfLotto(3000)).isEqualTo(3)
    }
}
