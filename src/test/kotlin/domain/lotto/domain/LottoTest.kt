package domain.lotto.domain

import domain.lotto.domain.LottoNumber.Companion.of
import domain.lotto.error.InvalidLottoNumberSizeException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("로또(Lotto)")
class LottoTest {

    @Test
    fun `셔플 전략을 통해 로또를 생성한다`() {
        val expected = Lotto.of(
            sortedSetOf(
                of(1), of(2), of(3),
                of(4), of(5), of(6),
            )
        )
        val actual: Lotto = Lotto.of { it.sorted() }

        assertAll(
            { assertThat(actual).isNotNull },
            { assertThat(actual).isExactlyInstanceOf(Lotto::class.java) },
            { assertThat(actual).isEqualTo(expected) }
        )
    }

    @Test
    fun `숫자로 변환 가능한 문자열을 입력하면 로또를 생성한다`() {
        val expected = Lotto.of(
            sortedSetOf(
                of(1), of(2), of(3),
                of(4), of(5), of(6),
            )
        )

        val lottoString = "1, 2, 3, 4, 5, 6"
        val actual: Lotto = Lotto.of(lottoString) { it.split(", ") }

        assertAll(
            { assertThat(actual).isNotNull },
            { assertThat(actual).isExactlyInstanceOf(Lotto::class.java) },
            { assertThat(actual).isEqualTo(expected) }
        )
    }

    @Test
    fun `로또의 숫자 개수가 6개가 아니면 예외를 발생시킨다`() {
        val sortedSetOf = sortedSetOf(
            of(1), of(2),
            of(3), of(4), of(5)
        )
        val exception = assertThrows<InvalidLottoNumberSizeException> { Lotto.of(sortedSetOf) }
        assertThat(exception.message).isEqualTo("Lotto 에 속한 LottoNumber 의 개수 %s는 6이 아니다.".format(sortedSetOf.size))
    }

    @Test
    fun `다른 로또와 비교해서 동일한 로또번호의 개수를 반환한다`() {
        val standard: Lotto = Lotto.of("1, 2, 3, 4, 5, 6") { it.split(", ") }
        val allMatch: Lotto = Lotto.of("1, 2, 3, 4, 5, 6") { it.split(", ") }
        val nonMatch: Lotto = Lotto.of("45, 44, 43, 42, 41, 40") { it.split(", ") }
        val someMatch: Lotto = Lotto.of("4, 5, 6, 7, 8, 9") { it.split(", ") }

        assertAll(
            { assertThat(standard.match(allMatch)).isEqualTo(6) },
            { assertThat(standard.match(nonMatch)).isZero() },
            { assertThat(standard.match(someMatch)).isEqualTo(3) },
        )
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1, 2, 3, 4, 5, 6:1:true", "1, 2, 3, 4, 5, 6:6:true", "1, 2, 3, 4, 5, 6:7:false",
            "40, 41, 42, 43, 44, 45:40:true", "40, 41, 42, 43, 44, 45:45:true", "40, 41, 42, 43, 44, 45:39:false"
        ], delimiter = ':'
    )
    fun `동일한 로또 번호를 가지고 있는지 여부를 반환한다`(lottoString: String, bonusBall: Int, expected: Boolean) {
        val lotto = Lotto.of(lottoString) { it.split(",") }
        val bonusBall = LottoNumber.of(bonusBall)
        val actual = lotto.contains(bonusBall)

        assertThat(actual).isEqualTo(expected)
    }
}
