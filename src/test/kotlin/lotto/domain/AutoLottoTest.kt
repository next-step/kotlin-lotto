package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class AutoLottoTest {

    @Test
    @DisplayName("6개의 숫자를 뽑음")
    fun `Pick six numbers`() {
        val number = AutoLotto.create()

        assertThat(number.size).isEqualTo(6)
    }
}
