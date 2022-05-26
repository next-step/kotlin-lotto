package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoResultTest {

    @Test
    fun `보너스 번호를 포함한 Enum 값을 추가한다`() {
        assertThat(LottoResult.Prize.values().contains(LottoResult.Prize.FIFTH_BONUS)).isEqualTo(true)
    }
}
