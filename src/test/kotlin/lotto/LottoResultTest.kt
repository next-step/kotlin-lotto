package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoResultTest {

    @Test
    fun `보너스 번호를 포함한 Enum 값을 추가한다`() {
        assertThat(LottoResult.Prize.values().contains(LottoResult.Prize.FIFTH_BONUS)).isEqualTo(true)
    }

    @Test
    fun `보너스 규칙(숫자 5 + 보너스 1개)에 부합하는 경우 보너스 Prize을 반환한다`(){
        assertThat(LottoResult.Prize.getOrNull(matchCount = 5, matchBonus = true)).isEqualTo(LottoResult.Prize.FIFTH_BONUS)
    }
}
