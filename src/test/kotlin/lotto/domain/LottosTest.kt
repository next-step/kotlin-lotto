package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {
    private lateinit var bonus: LottoNumber
    private lateinit var lotto: Lotto
    private lateinit var winningNumbers: Lotto
    private lateinit var winningLotto: WinningLotto
    private lateinit var lottos: Lottos

    @BeforeEach
    fun `set up`() {
        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) })
        lottos = Lottos(listOf(lotto))

        winningNumbers = Lotto(listOf(1, 2, 3, 10, 20, 30).map { LottoNumber.of(it) })
        bonus = LottoNumber.of(45)
        winningLotto = WinningLotto(winningNumbers, bonus)
    }

    @DisplayName("당첨번호와의 일치 개수, 보너스 번호와의 일치 여부를 계산하여, 각 로또의 등수를 리스트로 반환하는 기능이 있다")
    @Test
    fun `ranks result`() {
        // when
        val ranks = lottos.match(winningLotto)

        assertThat(ranks[0]).isEqualTo(Rank.FIFTH)
    }
}
