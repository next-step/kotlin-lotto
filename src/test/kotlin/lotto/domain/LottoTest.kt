package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTest {

    @DisplayName(value = "숫자 6자리의 로또를 발급한다")
    @Test
    fun generateLotto() {
        assertThat(Lotto().numbers).hasSize(6).allSatisfy { it in 1..45 }
    }
}
