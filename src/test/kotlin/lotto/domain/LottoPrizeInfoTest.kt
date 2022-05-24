package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoPrizeInfoTest {
    @MethodSource("providePrizeInfoTest")
    @ParameterizedTest
    fun `로또번호맞는 개수로 불러온 prize info가 맞는지 테스트`(count: Int, expectPrizeInfo: LottoPrizeInfo) {
        val answer = LottoPrizeInfo.getPrizeInfo(count)

        assertThat(answer).isEqualTo(expectPrizeInfo)
    }

    companion object {
        @JvmStatic
        private fun providePrizeInfoTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(3, LottoPrizeInfo.WIN3),
                Arguments.of(4, LottoPrizeInfo.WIN4),
                Arguments.of(5, LottoPrizeInfo.WIN5),
                Arguments.of(6, LottoPrizeInfo.WIN6),
            )
        }
    }
}
