package lotto.domain

import lotto.domain.model.Lotto
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTest {

    @DisplayName("로또 숫자는 6개이다")
    @Test
    fun numberSize() {
        val lotto = Lotto()
        val listSize = lotto.numbers.size

        assertThat(listSize).isEqualTo(6)
    }

    @DisplayName("로또 숫자들은 오름차순으로 정렬된다")
    @Test
    fun orderASC() {
        val lotto = Lotto()
        val first = lotto.numbers[0]
        val second = lotto.numbers[1]

        assertThat(first).isLessThan(second)
    }
}
