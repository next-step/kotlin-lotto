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
                LottoTicket(listOf(3, 5, 6, 7, 8, 13)),
                LottoTicket(listOf(3, 5, 6, 7, 8, 11)),
                LottoTicket(listOf(3, 5, 6, 7, 8, 9)),
                LottoTicket(listOf(3, 5, 6, 7, 8, 9))
            )
        )
        val winningNumbers = listOf<Int>(3, 5, 6, 7, 8, 9)

        val bonusNumber = LottoNumber.from(11)
        winningLotto = WinningLotto(LottoTicket(winningNumbers), bonusNumber)
    }

    @Test
    fun `당첨금 확인`() {
        val lottoesRank = lottoes.getMyLottoesRanks(winningLotto)
        assertThat(lottoesRank.getWinningMoney()).isEqualTo(4_031_500_000L)
    }
}
