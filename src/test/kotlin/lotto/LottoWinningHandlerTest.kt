package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoWinningHandlerTest {

    @Test
    fun `발급된 로또와 일치하는 숫자만큼의 결과를 출력해야 한다`() {
        val issuedLottos = listOf(
            LottoTicket(listOf(1, 5, 6, 8, 9, 11)),
            LottoTicket(listOf(2, 4, 5, 6, 8, 22)),
            LottoTicket(listOf(1, 4, 5, 6, 12, 55)),
        )
        val winningInfo = LottoWinningInfo("1,2,3,4,5,6", "7")

        val result = LottoWinningHandler.matchCount(issuedLottos, winningInfo.winningNumbers)
        assertThat(result.get(WinningPriceEnum.THREE)).isEqualTo(1)
        assertThat(result.get(WinningPriceEnum.FOUR)).isEqualTo(2)
    }

    @Test
    fun `일치하는 금액의 합을 구한다`() {
        val issuedLottos = listOf(
            LottoTicket(listOf(1, 5, 6, 8, 9, 11)),
            LottoTicket(listOf(2, 4, 5, 6, 8, 22)),
            LottoTicket(listOf(1, 4, 5, 6, 12, 55)),
        )
        val winningInfo = LottoWinningInfo("1,2,3,4,5,6", "7")

        LottoWinningHandler.matchCount(issuedLottos, winningInfo.winningNumbers)
        winningInfo.setScore(issuedLottos)
        val sum = LottoWinningHandler.calculateRevenue(winningInfo.scoreInfos)

        assertThat(sum).isEqualTo(55000)
    }

    @Test
    fun `보너스 숫자가 일치하면 추가 금액이 계산된다`() {
        val issuedLottos = listOf(
            LottoTicket(listOf(1, 2, 3, 4, 5, 7)),
            LottoTicket(listOf(2, 4, 5, 6, 8, 22)),
            LottoTicket(listOf(1, 4, 5, 6, 12, 55)),
        )
        val winningInfo = LottoWinningInfo("1,2,3,4,5,6", "7")

        winningInfo.setScore(issuedLottos)
        val sum = LottoWinningHandler.calculateRevenue(winningInfo.scoreInfos)

        assertThat(sum).isEqualTo(31550000)
    }

    @Test
    fun `일치하는 숫자가 나온 것에 대해서만 scorelist에 추가해야 한다`() {
        val issuedLottos = listOf(
            LottoTicket(listOf(1, 5, 6, 8, 9, 11)),
            LottoTicket(listOf(2, 4, 5, 6, 8, 22)),
            LottoTicket(listOf(1, 4, 5, 6, 12, 55)),
        )
        val winningInfo = LottoWinningInfo("41,42,43,44,45,40", "7")

        LottoWinningHandler.matchCount(issuedLottos, winningInfo.winningNumbers)

        assertThat(winningInfo.scoreInfos.size).isEqualTo(0)
    }
}
