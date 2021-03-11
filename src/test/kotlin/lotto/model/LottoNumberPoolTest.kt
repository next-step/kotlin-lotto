package lotto.model

import lotto.model.game.Lotto
import lotto.model.game.LottoNumberPool
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoNumberPoolTest {
    @Test
    fun `LottoNumberPool에서 숫자를 가져오면 6개는 모두 다른 숫자이다`() {
        // when
        val oneLotto: Lotto = LottoNumberPool.getOneLotto()

        // then
        assertThat(oneLotto.lottoNumbers.size).isEqualTo(6)
    }
}
