package lotto.domain

import lotto.domain.Prize.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal
import java.util.stream.Stream

class WinningResultTest {
    @Test
    fun `당첨 결과를 저장한다`() {
        val winningResult = WinningResult().apply {
            recordPrize(FIRST_PRIZE)
            recordPrize(FIRST_PRIZE)
            recordPrize(SECOND_PRIZE)
        }

        assertAll({
            assertThat(winningResult.result()[FIRST_PRIZE]).isEqualTo(2)
            assertThat(winningResult.result()[SECOND_PRIZE]).isEqualTo(1)
        })
    }

    @ParameterizedTest
    @MethodSource("arrangeRateOfReturnTest")
    fun `수익률을 반환한다`(money: Long, winningResult: WinningResult, expected: BigDecimal) {
        assertThat(winningResult.rateOfReturn(Money(money))).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun arrangeRateOfReturnTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1000, WinningResult().apply { recordPrize(FOURTH_PRIZE) }, BigDecimal.valueOf(5)),
                Arguments.of(10000, WinningResult().apply {
                    recordPrize(THIRD_PRIZE)
                    recordPrize(FOURTH_PRIZE)
                }, BigDecimal.valueOf(5.5)),
                Arguments.of(
                    20000,
                    WinningResult().apply { recordPrize(FOURTH_PRIZE) },
                    BigDecimal.valueOf(0.25)
                ),
            )
        }
    }
}
