package lotto.domain

import org.assertj.core.api.Assertions
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
}
