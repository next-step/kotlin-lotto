package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class LottoTest {
    @Test
    fun `Lotto should have 6 LottoNumbers`() {
        // given
        val numbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )

        // when && then
        assertDoesNotThrow { Lotto(numbers) }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidSizeNumbers")
    fun `Throw IllegalArgument exception when Lotto doesn't have 6 LottoNumbers`(numbers: List<Int>) {
        // given
        val lottoNumbers = numbers.map { LottoNumber(it) }

        // when && then
        assertThrows<IllegalArgumentException> { Lotto(lottoNumbers) }
    }

    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    @ParameterizedTest
    fun `Return whether it has certain number`(number: Int) {
        // given
        val lotto = (1..6).map { LottoNumber(it) }
        val lottoNumber = LottoNumber(number)
        val expected = true

        // when
        val actual = lotto.contains(lottoNumber)

        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideInvalidSizeNumbers(): Stream<List<Int>> =
            Stream.of(
                listOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 5, 6, 7),
            )
    }
}
