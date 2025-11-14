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
        assertThat(automaticLotto).hasSize(6)
        assertThat(automaticLotto.filter { it > 45 || it < 1 }).hasSize(0)
    }
}
