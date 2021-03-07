package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun `로또의 당첨된 번호를 구한다`() {
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val result = lotto.matchCount(Lotto(7, 3, 2, 1))
        val expect = listOf(LottoNum(3), LottoNum(2), LottoNum(1))
        assertThat(result).containsExactlyInAnyOrderElementsOf(expect)
    }
}
