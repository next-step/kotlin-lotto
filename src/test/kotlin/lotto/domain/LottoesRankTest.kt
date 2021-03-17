package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoesRankTest {

    private lateinit var lottoes: Lottoes
    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun init() {
        lottoes = Lottoes(
            listOf(
                LottoTicket.generateManual(listOf(3, 5, 6, 7, 8, 13)),
                LottoTicket.generateManual(listOf(3, 5, 6, 7, 8, 11)),
                LottoTicket.generateManual(listOf(3, 5, 6, 7, 8, 9)),
                LottoTicket.generateManual(listOf(3, 5, 6, 7, 8, 9))
            )
        )
        val winningNumbers = setOf<LottoNumber>(
            LottoNumber.from(3),
            LottoNumber.from(5),
            LottoNumber.from(6),
            LottoNumber.from(7),
            LottoNumber.from(8),
            LottoNumber.from(9)
        )

        val bonusNumber = LottoNumber.from(11)
        winningLotto = WinningLotto(LottoTicket(winningNumbers), bonusNumber)
    }

    @Test
    fun `등수 별 인원 확인`() {
        val lottoesRank = lottoes.getMyLottoesRanks(winningLotto)
        assertThat(lottoesRank.getRanks()).isEqualTo(
            mapOf(Rank.FIRST to 2, Rank.SECOND to 1, Rank.THIRD to 1)
        )
    }

    @Test
    fun `당첨금 확인`() {
        val lottoesRank = lottoes.getMyLottoesRanks(winningLotto)
        assertThat(lottoesRank.getWinningMoney()).isEqualTo(4_031_500_000L)
    }
}
