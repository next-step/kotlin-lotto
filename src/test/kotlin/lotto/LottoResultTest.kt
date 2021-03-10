package lotto

import lotto.domain.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    val lottoResult = LottoResult()
    val lotto = LottoTicket.generateAuto()
    val lottos = Lottoes(
        listOf(
            LottoTicket.generateManual(listOf(3, 5, 6, 7, 8, 13)),
            LottoTicket.generateManual(listOf(3, 5, 6, 7, 8, 11)),
            LottoTicket.generateManual(listOf(3, 5, 6, 7, 8, 9)),
            LottoTicket.generateManual(listOf(5, 21, 31, 44, 25, 10))
        )
    )
    val prizeNumbers = listOf<Int>(3, 5, 6, 7, 8, 9)
    val bonusNumber = 11

    @Test
    fun `로또 번호들의 등수 확인`() {
        val ranks = lottoResult.getMyLottoesRank(lottos, WinningLotto(prizeNumbers, bonusNumber))

        assertThat(ranks).isEqualTo(listOf(Rank.THIRD, Rank.SECOND, Rank.FIRST, Rank.MISS))
    }
}
