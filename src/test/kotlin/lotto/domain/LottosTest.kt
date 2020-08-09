package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {
    private lateinit var lotto: Lotto
    private lateinit var winningNumbers: Lotto
    private lateinit var winningLotto: WinningLotto
    private lateinit var lottos: Lottos

    @BeforeEach
    fun `set up`() {
        lotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        winningNumbers = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(10),
                LottoNumber(20),
                LottoNumber(30)
            )
        )
        winningLotto = WinningLotto(winningNumbers, LottoNumber(45))
        lottos = Lottos(listOf(lotto))
    }

    @DisplayName("당첨번호와의 일치 개수, 보너스 번호와의 일치 여부를 계산하여, 각 로또의 등수를 리스트로 반환하는 기능이 있다")
    @Test
    fun `rank matched`() {
        // when
        val ranks = lottos.match(winningLotto)

        assertThat(ranks[0]).isEqualTo(Rank.FIFTH)
    }
}
