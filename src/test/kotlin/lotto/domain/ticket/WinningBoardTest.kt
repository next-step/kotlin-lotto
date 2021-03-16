package lotto.domain.ticket

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinningBoardTest {

    @ParameterizedTest
    @CsvSource(value = ["FIVE,FIVE_WITH_BONUS", "NONE,NONE", "THREE,THREE", "FIVE_WITH_BONUS,FIVE_WITH_BONUS", "SIX,SIX"])
    fun `5개를 맞추고 보너스 번호도 맞추면 5개 보너스로 업그레이드, 나머지는 그대로`(winningBoard: WinningBoard, result: WinningBoard) {
        // when
        val expect = winningBoard.upgrade(true)

        // then
        assertThat(expect).isEqualTo(result)
    }
}
