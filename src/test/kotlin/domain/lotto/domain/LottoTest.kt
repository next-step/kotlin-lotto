package domain.lotto.domain

import domain.lotto.domain.LottoNumber.Companion.of
import domain.lotto.error.InvalidLottoNumberSizeException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

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
        val actual: Lotto = Lotto.of(lottoString) { it.split(", ")}

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
}
