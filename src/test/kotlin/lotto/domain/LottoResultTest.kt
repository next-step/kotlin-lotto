package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoResultTest {

    @MethodSource("provideLottoResultTestData")
    @ParameterizedTest
    fun `LottoResult가 맞는 로또가 있을경우 매치카운트가 +1되는지 테스트`(count: Int, prizeInfo: LottoPrizeInfo) {
        val lottoResult = LottoResult(prizeInfo)
        val beforeMatch = lottoResult.count
        lottoResult.increaseMatchCount()

        val answer = lottoResult.count
        val expect = beforeMatch + 1
        assertThat(answer).isEqualTo(expect)
    }

    @MethodSource("provideLottoResultTestData")
    @ParameterizedTest
    fun `LottoResult가 맞는 로또가 있을경우 각 상금의 금액이 리턴되는지 테스트`(count: Int, prizeInfo: LottoPrizeInfo) {
        val lottoResult = LottoResult(prizeInfo)

        val answer = lottoResult.getPrizeMoney()
        val expect = prizeInfo.money
        assertThat(answer).isEqualTo(expect)
    }

    companion object {
        @JvmStatic
        private fun provideLottoResultTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(3, LottoPrizeInfo.WIN3),
                Arguments.of(4, LottoPrizeInfo.WIN4),
                Arguments.of(5, LottoPrizeInfo.WIN5),
                Arguments.of(6, LottoPrizeInfo.WIN6),
            )
        }
    }
}
