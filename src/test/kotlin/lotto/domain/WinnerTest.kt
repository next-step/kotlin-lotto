package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinnerTest {
    @ParameterizedTest
    @CsvSource("1|2|3|4|5|6,7", "1|2|3|42|43|44,45")
    fun `여섯개의 당첨번호와 하나의 보너스 점수를 갖는다`() {
        Assertions.assertThat(
            Winner(
                Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                LottoNumber(7)
            )
        ).isNotNull

        Assertions.assertThatThrownBy {
            Winner(
                Lotto(listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) }),
                LottoNumber(7)
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `Winner의 BonusNumber 는 Lotto에 포함된 수와 중복될 수 없다`() {
        Assertions.assertThatThrownBy {
            Winner(
                Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                LottoNumber(6)
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `Lotto를 파라미터로 받아 WinnerType을 반환한다`() {

        Assertions.assertThat(
            Winner(
                Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                LottoNumber(7)
            ).check(Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }))
        ).isEqualTo(WinnerType.MATCHED_SIX_NUMBERS)
    }
}
