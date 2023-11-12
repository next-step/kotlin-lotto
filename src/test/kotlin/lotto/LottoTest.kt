package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또를 생성할 수 있다`() {
        val lotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto).isNotNull
    }

    @Test
    fun `로또 번호를 가져올 수 있다`() {
        val lotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val expectedLotto: List<LottoNumber> = listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))

        assertThat(lotto.numberList).containsExactlyElementsOf(expectedLotto)
    }

    @Test
    fun `로또 번호가 겹치는 것을 반환`() {
        val firstLotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val secondLotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

        val matchCount: Int = firstLotto.getMatchCount(secondLotto)

        assertThat(matchCount).isEqualTo(5)
    }

    @Test
    fun `로또 번호는 정렬되어 있다`() {
        val lotto: Lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))

        val expectedLotto: List<LottoNumber> = listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))

        assertThat(lotto.numberList).containsExactlyElementsOf(expectedLotto)
    }

    @Test
    fun `로또 번호는 중복될 수 없다`() {
        Assertions.assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 중복될 수 없습니다.")
    }
}
