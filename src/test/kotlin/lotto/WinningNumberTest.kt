package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumberTest {
    @Test
    fun `당첨번호가 있다`() {
        assertThat(WinningNumber.Console("지난 주 당첨 번호를 입력해 주세요.", "1,2,3,4,5,6\n").lottoNumbers)
            .isEqualTo(LottoNumbers(1, 2, 3, 4, 5, 6))
    }
}
