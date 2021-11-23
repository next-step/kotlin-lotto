package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class LottoTest {
    @Test
    fun `로또 티켓을 생성한다`() {
        val lotto = Lotto.of(1, 2, 3, 4, 5, 6)
        val other = Lotto.of("1,2,3,4,5,6")
        val expected = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )
        assertAll(
            { assertThat(lotto).isEqualTo(other) },
            { assertThat(lotto.toList()).isEqualTo(expected) }
        )
    }

    @CsvSource("6,6", "7,5")
    @ParameterizedTest
    fun `로또티켓 번호 맞춘 개수를 반환한다`(value: Int, expected: Int) {
        val lotto = Lotto.of(1, 2, 3, 4, 5, 6)
        val other = Lotto.of(1, 2, 3, 4, 5, value)
        assertThat(lotto.matchCount(other)).isEqualTo(expected)
    }

    @NullAndEmptySource
    @ParameterizedTest
    fun `null이나 빈 값이 입력되면 예외를 발생한다`(value: String?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto.of(value) }
            .withMessage("티켓 번호들은 빈 값이거나 null일 수 없습니다.")
    }

    @Test
    fun `로또 티켓에 번호가 6개가 아니라면 예외를 발생한다`() {
        assertAll(
            {
                assertThatExceptionOfType(IllegalArgumentException::class.java)
                    .isThrownBy { Lotto.of(1, 2, 3, 4, 5) }
            },
            {
                assertThatExceptionOfType(IllegalArgumentException::class.java)
                    .isThrownBy { Lotto.of() }
            },
        )
    }

    @Test
    fun `로또 티켓에 중복된 번호가 있으면 예외를 발생한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto.of(1, 1, 1, 1, 1, 1) }
    }
}
