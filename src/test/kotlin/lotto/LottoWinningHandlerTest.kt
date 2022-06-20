package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoWinningHandlerTest {

    @Test
    fun `발급된 로또와 일치하는 숫자만큼의 결과를 출력해야 한다`() {
        val issuedLottos = listOf(
            LottoTicket(listOf(LottoNumber(1)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(8)
                , LottoNumber(9)
                , LottoNumber(11)
            )),
            LottoTicket(listOf(LottoNumber(2)
                , LottoNumber(4)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(8)
                , LottoNumber(22)
            )),
            LottoTicket(listOf(LottoNumber(1)
                , LottoNumber(4)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(12)
                , LottoNumber(45)
            )),
        )
        val winningInfo = LottoWinningInfo("1,2,3,4,5,6", "7")

        val result = winningInfo.winningLottoTicket.matchCount(issuedLottos)
        assertThat(result.get(WinningPriceEnum.THREE)).isEqualTo(1)
        assertThat(result.get(WinningPriceEnum.FOUR)).isEqualTo(2)
    }

    @Test
    fun `일치하는 금액의 합을 구한다`() {
        val issuedLottos = listOf(
            LottoTicket(listOf(LottoNumber(1)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(8)
                , LottoNumber(9)
                , LottoNumber(11)
            )),
            LottoTicket(listOf(LottoNumber(2)
                , LottoNumber(4)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(8)
                , LottoNumber(22)
            )),
            LottoTicket(listOf(LottoNumber(1)
                , LottoNumber(4)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(12)
                , LottoNumber(45)
            )),
        )

        val winningInfo = LottoWinningInfo("1,2,3,4,5,6", "7")

        winningInfo.winningLottoTicket.matchCount(issuedLottos)
        winningInfo.setScore(issuedLottos)
        val sum = winningInfo.winningLottoTicket.calculateRevenue(winningInfo.scoreInfos)

        assertThat(sum).isEqualTo(55000)
    }

    @Test
    fun `보너스 숫자가 일치하면 추가 금액이 계산된다`() {
        val issuedLottos = listOf(
            LottoTicket(listOf(LottoNumber(1)
                , LottoNumber(2)
                , LottoNumber(3)
                , LottoNumber(4)
                , LottoNumber(5)
                , LottoNumber(7)
            )),
            LottoTicket(listOf(LottoNumber(2)
                , LottoNumber(4)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(8)
                , LottoNumber(22)
            )),
            LottoTicket(listOf(LottoNumber(1)
                , LottoNumber(4)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(12)
                , LottoNumber(45)
            ))
        )
        val winningInfo = LottoWinningInfo("1,2,3,4,5,6", "7")

        winningInfo.setScore(issuedLottos)
        val sum = winningInfo.winningLottoTicket.calculateRevenue(winningInfo.scoreInfos)

        assertThat(sum).isEqualTo(31550000)
    }

    @Test
    fun `일치하는 숫자가 나온 것에 대해서만 scorelist에 추가해야 한다`() {
        val issuedLottos = listOf(
            LottoTicket(listOf(LottoNumber(1)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(8)
                , LottoNumber(9)
                , LottoNumber(11)
            )),
            LottoTicket(listOf(LottoNumber(2)
                , LottoNumber(4)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(8)
                , LottoNumber(22)
            )),
            LottoTicket(listOf(LottoNumber(1)
                , LottoNumber(4)
                , LottoNumber(5)
                , LottoNumber(6)
                , LottoNumber(12)
                , LottoNumber(45)
            )),
        )
        val winningInfo = LottoWinningInfo("41,42,43,44,45,40", "7")

        winningInfo.winningLottoTicket.matchCount(issuedLottos)

        assertThat(winningInfo.scoreInfos.size).isEqualTo(0)
    }
}
