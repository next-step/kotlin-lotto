package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.Lotto.Companion.LOTTO_NUMBER_RANGE
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `RandomNumberGenerator를 생성자 파라미터로 받아 임의의 값으로 초기화한다`() {
        val lotto = Lotto(RandomNumberGenerator())
        Assertions.assertThat(LOTTO_NUMBER_RANGE.count { number -> lotto.contains(number) })
            .isEqualTo(LOTTO_NUMBER_COUNT)
    }

    @Test
    fun `숫자목록 생성자 파라미터로 받아 임의의 값으로 초기화한다`() {
        val numbers = listOf(1, 5, 7, 11, 25, 45)
        val lotto = Lotto(numbers)

        LOTTO_NUMBER_RANGE.forEach {
            Assertions.assertThat(lotto.contains(it)).isEqualTo(numbers.contains(it))
        }
    }

    @Test
    fun `로또 범위를 벗어나는 입력이 들어오면 예외를 반환한다`() {
        Assertions.assertThatThrownBy { Lotto(listOf(-1, 5, 7, 11, 25, 45)) }
            .isInstanceOf(IllegalArgumentException::class.java)

        Assertions.assertThatThrownBy { Lotto(listOf(0, 5, 7, 11, 25, 46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
