package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 23, 45])
    fun `1~45 사이의 로또 번호 생성`(value: Int) {
        // when
        val create = { LottoNumber(value) }

        // then
        assertDoesNotThrow(create)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 46])
    fun `1~45 이외의 숫자로 로또 번호를 생성하면 예외 발생`(value: Int) {
        // when
        val create: () -> Unit = { LottoNumber(value) }

        // then
        assertThrows<IllegalArgumentException>(create)
    }

    @Test
    fun `로또 번호는 오름차순으로 정렬된다`() {
        // given
        val numbers = listOf(10, 5, 6, 9, 2).map(::LottoNumber)

        // when
        val result = numbers.sorted()

        // then
        val expected = listOf(2, 5, 6, 9, 10).map(::LottoNumber)
        assertThat(result).isEqualTo(expected)
    }
}
