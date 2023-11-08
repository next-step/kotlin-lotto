@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `입력된 로또 번호가 1~45 사이의 숫자가 아니면 IllegalArgumentException이 발생한다`() {
        val number = 46

        val actual = catchThrowable {
            LottoNumber(number)
        }

        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto number should be in range of 1~45.")
    }
}
