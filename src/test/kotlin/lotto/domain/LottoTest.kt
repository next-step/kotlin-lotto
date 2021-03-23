package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 7, 8, 9, 10, 11])
    fun `로또번호를 생성 할 때 번호 개수가 6개에 만족하지 않으면 예외가 발생한다`(numberSize: Int) {
        assertThrows<IllegalArgumentException> {
            Lotto.from((1..numberSize).map { LottoNumber.from(it) })
        }
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5,6', 5, true",
        "'1,2,3,4,5,6', 7, false",
        "'11,30,41,44,7,8', 11, true",
        "'11,30,41,44,7,8', 8, true",
        "'11,30,41,44,7,8', 9, false"
    )
    fun `로또번호가 로또에 존재 하면 참 그렇지 않으면 거짓을 반환한다`(stringNumbers: String, containTargetNumber: Int, expected: Boolean) {
        val lotto = Lotto.from(stringNumbers.split(",").map { LottoNumber.from(it.toInt()) })

        val actual = lotto.contains(LottoNumber.from(containTargetNumber))

        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5,6', '2,3,4,5,6,7', 5",
        "'1,2,3,4,5,6', '3,4,5,7,8,9', 3",
        "'1,2,3,4,5,6', '2,5,44,30,31,32', 2",
        "'1,2,3,4,5,6', '40,41,42,43,44,45', 0"
    )
    fun `두 로또에 대해서 매치되는 번호 개수를 반환한다`(stringNumbers1: String, stringNumbers2: String, expectCount: Int) {
        val lotto1 = Lotto.from(stringNumbers1.split(",").map { LottoNumber.from(it.toInt()) })
        val lotto2 = Lotto.from(stringNumbers2.split(",").map { LottoNumber.from(it.toInt()) })

        val count = lotto1.count(lotto2)

        assertThat(count).isEqualTo(expectCount)
    }
}
