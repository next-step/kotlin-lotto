package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    private val lotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
    private val winningLotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })

    @Test
    fun `로또 매칭 카운트 테스트`() {
        assertThat(lotto.matchCount(winningLotto)).isEqualTo(6)
    }

    @Test
    fun `보너스 매칭 테스트`() {
        assertThat(lotto.matchBonus(LottoNumber.from(2))).isEqualTo(true)
    }
}
