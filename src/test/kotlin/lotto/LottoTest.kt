package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumberList
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또를 생성할 수 있다`() {
        val lotto: Lotto = Lotto(LottoNumberList(listOf(1, 2, 3, 4, 5, 6)))

        assertThat(lotto).isNotNull
    }

    @Test
    fun `로또 번호를 가져올 수 있다`() {
        val lotto: Lotto = Lotto(LottoNumberList(listOf(1, 2, 3, 4, 5, 6)))

        assertThat(lotto.getNumberList()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `로또 번호가 겹치는 것을 반환`() {
        val firstLotto: Lotto = Lotto(LottoNumberList(listOf(1, 2, 3, 4, 5, 6)))
        val secondLotto: Lotto = Lotto(LottoNumberList(listOf(1, 2, 3, 4, 5, 7)))

        val matchCount: Int = firstLotto.getMatchCount(secondLotto)

        assertThat(matchCount).isEqualTo(5)
    }
}
