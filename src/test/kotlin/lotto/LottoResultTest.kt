package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoResultTest {

    @Test
    fun `로또 결과의 Prize 결과값 확인`() {
        assertThat(LottoResult().check { return@check (1..3).toSet() }.prize).isEqualTo(LottoResult.Prize.THIRD)
    }
}
