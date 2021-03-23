package domain.lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumbersTest {
    @Test
    fun `로또숫자열은 여섯 개의 로또숫자로 생성된다`() {
        assertDoesNotThrow {
            LottoNumbers(
                sortedSetOf(
                    LottoNumber.N01,
                    LottoNumber.N02,
                    LottoNumber.N03,
                    LottoNumber.N04,
                    LottoNumber.N05,
                    LottoNumber.N06
                )
            )
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 5, 7])
    fun `로또숫자열은 숫자 6개 이외로는 생성할 수 없다`(lottoNumberCount: Int) {
        assertThatIllegalArgumentException()
            .isThrownBy { LottoNumbers.fromList((1..lottoNumberCount).map { LottoNumber.parse(it) }) }
    }

    @ParameterizedTest
    @CsvSource(
        "1, 1, 1, 1, 1, 1",
        "1, 2, 3, 4, 5, 5",
        "45, 45, 1, 5, 1, 6"
    )
    fun `로또숫자열 내의 로또숫자는 서로 같을 수 없다`(n1: Int, n2: Int, n3: Int, n4: Int, n5: Int, n6: Int) {
        assertThatIllegalArgumentException().isThrownBy { lottoNumberOf(n1, n2, n3, n4, n5, n6) }
    }

    @Test
    fun `로또숫자열 내의 로또숫자는 생성 시 순서와 관계없이 정렬되어 있다`() {
        assertThat(lottoNumberOf(9, 1, 43, 2, 8, 10).numbers)
            .containsExactlyElementsOf(listOf(1, 2, 8, 9, 10, 43).map { LottoNumber.parse(it) })
    }

    @ParameterizedTest
    @CsvSource(
        "'1:2:3:4:5:6','3:4:5:6:7:8',4",
        "'1:2:3:4:5:6','40:41:42:43:44:45',0",
        "'1:9:26:28:30:41','1:9:26:28:30:41',6"
    )
    fun `다른 로또숫자열과 비교하면, 일치하는 로또숫자의 개수를 반환한다`(someNumbers: String, otherNumbers: String, count: Int) {
        val some = parseLottoNumbers(someNumbers)
        val other = parseLottoNumbers(otherNumbers)
        assertThat(some.countIntersection(other)).isEqualTo(count)
    }

    private fun parseLottoNumbers(someNumbers: String): LottoNumbers {
        return someNumbers.split(":")
            .map { it.toInt() }
            .map { LottoNumber.parse(it) }
            .let { LottoNumbers(it.toSortedSet()) }
    }
}
