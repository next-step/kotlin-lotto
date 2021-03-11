package lotto.domain.result

import lotto.domain.ticket.WinningBoard
import lotto.domain.ticket.WinningBoard.FIVE
import lotto.domain.ticket.WinningBoard.FOUR
import lotto.domain.ticket.WinningBoard.NONE
import lotto.domain.ticket.WinningBoard.SIX
import lotto.domain.ticket.WinningBoard.THREE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoResultTest {
    @ParameterizedTest
    @ValueSource(strings = ["NONE", "THREE", "FOUR", "FIVE", "SIX"])
    fun `결과의 초기값은 모두 0이다`(winningBoard: WinningBoard) {
        //given
        val result = LottoResult()

        //when
        val amount = result.get(winningBoard)

        //then
        assertThat(amount).isEqualTo(0)
    }

    @Test
    fun `로또 결과의 총 상금을 반환한다`() {
        //given
        val result = LottoResult()
        result.add(NONE)
        result.add(THREE)
        result.add(FOUR)
        result.add(FIVE)
        result.add(SIX)

        val expectReward = NONE.reward + THREE.reward + FOUR.reward + FIVE.reward + SIX.reward

        //when
        val resultReward = result.calculateTotalReward()

        //then
        assertThat(resultReward).isEqualTo(expectReward)
    }
}
