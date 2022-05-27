package lotto.domain

import lotto.generator.NumbersGenerator
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `로또 번호는 6개다`() {
        assertThat(LottoTicket(NumbersGenerator.create()).numbers.size).isEqualTo(6)
    }

    @Test
    fun `로또 번호 입력으로 6개 미만의 숫자열이 들어가면 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            LottoTicket(listOf())
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또 번호는 각각 1 이상 45 이하이다`() {
        assertThat(LottoTicket(NumbersGenerator.create()).numbers).allMatch { number -> number in 1..45 }
    }

    @Test
    fun `로또 번호로 음수가 들어가면 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            LottoTicket(listOf(1, 2, 3, 4, 5, -1))
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또 번호는 정렬되어 있다`() {
        assertThat(LottoTicket(listOf(6, 5, 1, 3, 2, 4)).numbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }
}
