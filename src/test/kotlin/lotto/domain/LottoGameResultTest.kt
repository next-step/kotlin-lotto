package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameResultTest {
    @Test
    fun `맞은 번호갯수가 같은 2등과 3등을 보너스로 구분할 수 있다`() {
        val second = LottoGameResult(LottoHit(5), BonusAble(true))
        val third = LottoGameResult(LottoHit(5))
        assertThat(third == second).isFalse
    }

    @Test
    fun `보너스만 다른 당첨 번호를 같다고 확인 할 수 있다`() {
        val second = LottoGameResult(LottoHit(4), BonusAble(true))
        val third = LottoGameResult(LottoHit(4))
        assertThat(third == second).isTrue
    }
}
