package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BuyerTest {
    @DisplayName(value = "금액에 따라 구입 가능한 로또의 수를 산출한다.")
    @Test
    fun buyLottoCount() {
        assertThat(getAutoLotto(Money(5000)).lottoInPaper.size).isSameAs(5)
        assertThat(getAutoLotto(Money(14600)).lottoInPaper.size).isSameAs(14)
    }
}
