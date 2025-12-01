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
        assertThat(automaticLotto.numbers.filter { it.number > LottoNumber.MAX_NUMBER || it.number < LottoNumber.MIN_NUMBER }).hasSize(0)
    }
}
