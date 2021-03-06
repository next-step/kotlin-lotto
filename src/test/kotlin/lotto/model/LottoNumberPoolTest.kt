package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoNumberPoolTest {
    @Test
    fun `LottoNumberPool에서 숫자를 가져오면 6개는 모두 다른 숫자이다`() {
        // given
        val numberPool = LottoNumberPool()

        // when
        val numbers: List<Int> = numberPool.getLottoNumbers()

        // then
        assertThat(numbers.toSet().size).isEqualTo(6)
    }
}
