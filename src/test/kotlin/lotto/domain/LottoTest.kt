package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {

    @DisplayName("로또를 생성하면 중복되지 않은 6개의 숫자를 반환한다")
    @Test
    fun createLottoTest() {
        // given
        val lotto = Lotto()

        // when
        val numbers = lotto.numbers

        // then
        assertThat(numbers.distinct()).hasSize(6)
        assertThat(numbers).isEqualTo(numbers.sortedBy { it.number })
    }
}