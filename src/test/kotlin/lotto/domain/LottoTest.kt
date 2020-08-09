package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun can_not_get_same_number() {
        val numbers = setOf(1, 2, 3, 4, 5, 5)
        assertThatThrownBy {
            Lotto(numbers)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("6개의 번호만 가질수 있습니다.")
    }

    @Test
    fun can_get_six_number() {
        val numbers = setOf(1, 2, 3, 4, 5, 6, 7)
        assertThatThrownBy {
            Lotto(numbers)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("6개의 번호만 가질수 있습니다.")
    }

    @Test
    fun get_count_match() {
        val numbers = setOf(1, 2, 3, 4, 5, 6)
        val correctNumbers = setOf(1, 2, 7, 3, 8, 9)
        val lotto = Lotto(numbers)
        val correctLotto = Lotto(correctNumbers)

        val countMatch = lotto.getCountMatch(correctLotto.numbers)

        assertThat(countMatch).isEqualTo(3)
    }
}
