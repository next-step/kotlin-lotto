package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoShufflerTest {
    @Test
    fun generateAutomaticLotto() {
        // given

        // when
        val automaticLotto = LottoShuffler.generateAutomaticLotto()

        // then
        assertThat(automaticLotto).isNotNull
        assertThat(automaticLotto.numbers).hasSize(6)
        assertThat(automaticLotto.numbers.filter { it > Lotto.MAX_NUMBER || it < Lotto.MIN_NUMBER }).hasSize(0)
    }
}
