package lotto.domain.prize

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoPrizeTest {
    @ParameterizedTest
    @MethodSource("provideLottoPrizes")
    fun `일치하는 번호 수에 따라 당첨 금액이 달라진다`(numberOfMatches: Int, expected: Int) {
        Assertions.assertThat(LottoPrize.of(numberOfMatches).prizeAmount).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun provideLottoPrizes(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(2, 0),
                Arguments.of(3, 5000),
                Arguments.of(4, 50000),
                Arguments.of(5, 1500000),
                Arguments.of(6, 2000000000)
            )
        }
    }
}
