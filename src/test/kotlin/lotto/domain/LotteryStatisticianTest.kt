package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LotteryStatisticianTest {

    @Test
    fun `6개의 수가 맞으면 1등이다`() {
        // given
        val targetLottoStr = "1, 2, 3, 4, 5, 6"
        val statistician = LotteryStatistician(targetLottoStr, 7)

        // when
        val result = statistician.statistics(
            listOf(Lotto(numbers = listOf(1, 2, 3, 4, 5, 6)))
        )

        // then
        assertThat(result.statistics[LottoRank.FIRST]).isEqualTo(1)
        assertThat(result.statistics[LottoRank.SECOND]).isEqualTo(0)
        assertThat(result.statistics[LottoRank.THIRD]).isEqualTo(0)
        assertThat(result.statistics[LottoRank.FOURTH]).isEqualTo(0)
    }

    @ParameterizedTest
    @MethodSource("provideInvalidateValue")
    fun `유효하지 않은 값을 입력하면 예외를 던진다`(input: String) {
        // when & then
        assertThatThrownBy { LotteryStatistician(input, 7) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 숫자의 범위는 ${LottoGenerator.RANGE} 입니다")
    }

    companion object {

        @JvmStatic
        fun provideInvalidateValue(): List<String> {
            return listOf(
                "-1,1,2,3,4,5",
                "stringvalue",
                "str,1,2,3,4,5",
                "46,1,2,3,4,5",
            )
        }

    }

}
