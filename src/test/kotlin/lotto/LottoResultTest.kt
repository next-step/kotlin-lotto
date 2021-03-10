package lotto

import lotto.domain.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    private val lottoResult = LottoResult()
    private val lotto = LottoTicket.generateAuto()
    private val lottos = Lottoes(
        listOf(
            LottoTicket.generateManual(listOf(3, 5, 6, 7, 8, 13)),
            LottoTicket.generateManual(listOf(3, 5, 6, 7, 8, 11)),
            LottoTicket.generateManual(listOf(3, 5, 6, 7, 8, 9)),
            LottoTicket.generateManual(listOf(5, 21, 31, 44, 25, 10))
        )
    )
    private val winningNumbers = listOf<LottoNumber>(
        LottoNumber(3),
        LottoNumber(5),
        LottoNumber(6),
        LottoNumber(7),
        LottoNumber(8),
        LottoNumber(9)
    )

    private val bonusNumber = LottoNumber(11)
    private val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    @Test
    fun `로또 번호들의 등수 확인`() {
        val ranks = lottoResult.getMyLottoesRank(lottos, winningLotto)

        assertThat(ranks).isEqualTo(listOf(Rank.THIRD, Rank.SECOND, Rank.FIRST, Rank.MISS))
    }

    @Test
    fun `보너스 번호 맞았는지 확인`() {
        val bonusNumber = LottoNumber(5)
        val lotto = LottoTicket.generateManual(listOf(1, 2, 3, 4, 5, 6))
        println(lotto.value.contains(bonusNumber))
    }
}
