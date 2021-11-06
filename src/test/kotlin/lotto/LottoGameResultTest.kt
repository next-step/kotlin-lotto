package lotto

import lotto.domain.LottoGameResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameResultTest {
    @Test
    fun `맞은 번호갯수가 같은 2등과 3등을 보너스로 구분할 수 있다`() {
        val second = LottoGameResult(5, true)
        val third = LottoGameResult(5)
        assertThat(second == third).isFalse
    }
}
