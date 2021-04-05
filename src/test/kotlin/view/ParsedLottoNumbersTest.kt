package view

import domain.lotto.LottoNumbers
import domain.lotto.lottoNumberOf
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ParsedLottoNumbersTest {
    @Test
    fun `추출숫자열은 여섯 개의 정수리스트로 생성된다`() {
        assertDoesNotThrow { ParsedLottoNumbers(listOf(1, 2, 3, 4, 5, 6)) }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1,2,3,4,5",
            "1,2,3,4,5,6,7"
        ]
    )
    fun `추출숫자열은 숫자 6개 이외로는 생성할 수 없다`(intString: String) {
        val ints = intString.split(",").map { it.toInt() }
        assertThatIllegalArgumentException().isThrownBy { ParsedLottoNumbers(ints) }
    }

    @Test
    fun `추출숫자열은 서로 다른 객체라도, 가지고 있는 숫자가 일치하면 동일하다`() {
        val one = ParsedLottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val other = ParsedLottoNumbers(listOf(6, 5, 4, 3, 2, 1))

        assertThat(one).isEqualTo(other)
    }

    @Test
    fun `추출숫자열은 로또숫자열로 바꿀 수 있다`() {
        val numbers = listOf(11, 12, 13, 14, 15, 16)
        val parsedNumbers = ParsedLottoNumbers(numbers)
        val expected = lottoNumberOf(11, 12, 13, 14, 15, 16)

        // when
        val actual: LottoNumbers = parsedNumbers.toLottoNumbers()

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
