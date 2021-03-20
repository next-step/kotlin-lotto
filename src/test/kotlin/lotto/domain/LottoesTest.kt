package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoesTest {

    private lateinit var lottoes: Lottoes
    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun init() {
        lottoes = Lottoes(
            listOf(
                LottoTicket(listOf(3, 5, 6, 7, 8, 13)),
                LottoTicket(listOf(3, 5, 6, 7, 8, 11)),
                LottoTicket(listOf(3, 5, 6, 7, 8, 9)),
                LottoTicket(listOf(5, 21, 31, 44, 25, 10))
            )
        )
        val winningNumbers = listOf<Int>(3, 5, 6, 7, 8, 9)

        val bonusNumber = LottoNumber.from(11)
        winningLotto = WinningLotto(LottoTicket(winningNumbers), bonusNumber)
    }

    @Test
    fun `로또 번호들의 등수 확인`() {
        val lottoRanks = lottoes.getMyLottoesRanks(winningLotto)
        val ranks = lottoRanks.getRanks().keys
        assertThat(ranks.toList()).isEqualTo(listOf(Rank.THIRD, Rank.SECOND, Rank.FIRST, Rank.MISS))
    }

    @Test
    fun `등수 별 인원 확인`() {
        val lottoesRank = lottoes.getMyLottoesRanks(winningLotto)
        assertThat(lottoesRank.getRanks()).isEqualTo(
            mapOf(Rank.FIRST to 1, Rank.SECOND to 1, Rank.THIRD to 1, Rank.MISS to 1)
        )
    }
}
