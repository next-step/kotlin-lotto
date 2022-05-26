package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketResultTest {

    @Test
    fun `로또 결과의 Prize 결과값 확인`() {
        assertThat(LottoResult().check {
            (1..3).toList().map { LottoNumber(it) }.toSet()
        }.prize).isEqualTo(LottoResult.Prize.THIRD)
    }
}
