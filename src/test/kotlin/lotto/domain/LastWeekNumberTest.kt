package lotto.domain

import lotto.LottoNumberList.Companion.lottoNumberListOf
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LastWeekNumberTest {
    @Test
    fun `저번 당첨 번호가 중복을 포함 하여 6개가 입력될 경우 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy { LastWeekNumber(lottoNumberListOf(1, 2, 3, 3, 3, 3)) }
    }

    @ParameterizedTest
    @MethodSource("listSizeUnderSix")
    fun `저번 당첨 번호가 6개 미만으로 입력 될 경우 예외가 발생한다`(list: List<LottoNumber>) {
        assertThatIllegalArgumentException().isThrownBy { LastWeekNumber(list) }
    }

    @ParameterizedTest
    @MethodSource("listSizeOverSix")
    fun `저번 당첨 번호가 6개 초과로 입력 될 경우 예외가 발생한다`(list: List<LottoNumber>) {
        assertThatIllegalArgumentException().isThrownBy { LastWeekNumber(list) }
    }

    companion object {
        @JvmStatic
        fun listSizeUnderSix(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(lottoNumberListOf(1, 2, 3, 4, 5)),
                Arguments.of(lottoNumberListOf(1, 2, 3, 4)),
                Arguments.of(lottoNumberListOf(1, 2, 3)),
                Arguments.of(lottoNumberListOf(1, 2)),
                Arguments.of(lottoNumberListOf(1)),
                Arguments.of(lottoNumberListOf())
            )
        }

        @JvmStatic
        fun listSizeOverSix(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(lottoNumberListOf(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(lottoNumberListOf(1, 2, 3, 4, 5, 6, 7, 8))
            )
        }
    }
}
