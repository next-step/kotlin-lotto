package lotto.domain

import lotto.util.createLotto
import lotto.util.createLottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {
    private lateinit var lottoNumbers: List<LottoNumber>
    private lateinit var lotto: Lotto
    private lateinit var lottos: Lottos
    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun `set up`() {
        lottoNumbers = createLottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        lotto = createLotto(lottoNumbers)
        winningLotto = WinningLotto(lotto, LottoNumber(45))
        lottos = Lottos(listOf(lotto))
    }

    @DisplayName("당첨번호와의 일치 개수, 보너스 번호와의 일치 여부를 계산하여, 각 로또의 등수를 리스트로 반환하는 기능이 있다")
    @Test
    fun `rank matched`() {
        // when
        val ranks = lottos.match(winningLotto)

        // then
        assertThat(ranks[0]).isEqualTo(Rank.FIRST)
    }
}
