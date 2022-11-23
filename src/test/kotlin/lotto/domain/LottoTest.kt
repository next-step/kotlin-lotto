package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTest {

    @DisplayName("로또 숫자는 랜덤하게 생성된다")
    @Test
    fun randomNumber() {
        val firstLotto = Lotto()
        val secondLotto = Lotto()

        val firstSum = firstLotto.list.sum()
        val secondSum = secondLotto.list.sum()

        assertThat(firstSum).isNotEqualTo(secondSum)
    }

    @DisplayName("로또 숫자는 6개이다")
    @Test
    fun numberSize() {
        val lotto = Lotto()
        val listSize = lotto.list.size

        assertThat(listSize).isEqualTo(6)
    }

    @DisplayName("로또 숫자들은 오름차순으로 정렬된다")
    @Test
    internal fun orderASC() {
        val lotto = Lotto()
        val first = lotto.list[0]
        val second = lotto.list[1]

        assertThat(first).isLessThan(second)
    }
}
