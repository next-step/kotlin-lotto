package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoWinningHandlerTest {

    @Test
    fun `발급된 로또와 일치하는 숫자만큼의 결과를 출력해야 한다`() {
        val issuedLottos = listOf(
            listOf(1, 5, 6, 8, 9, 11),
            listOf(2, 4, 5, 6, 8, 22),
            listOf(1, 4, 5, 6, 12, 55),
        )
        val winningInfo = LottoWinningInfo("1,2,3,4,5,6")

        val result = LottoWinningHandler.matchCount(issuedLottos, winningInfo.winningNumbers)
        assertThat(result.get(3)).isEqualTo(1)
        assertThat(result.get(4)).isEqualTo(2)
    }
}
