package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoJudgmentTest {

    private val lastLottoTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))

    @Test
    fun `지난주 당첨 로또로 로또 판단기를 생성한다`() {
        LottoJudgment(lastLottoTicket)
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersAndMatchCount")
    fun `지난주 당첨 번호와 일치하는 갯수를 확인한다`(numbers: List<Int>, matchCount: Int) {
        val myLottoTicket = LottoTicket(numbers)

        val lottoJudgment = LottoJudgment(lastLottoTicket)

        val matchNumberCount = lottoJudgment.matchNumberCount(myLottoTicket)
        Assertions.assertThat(matchNumberCount).isEqualTo(matchCount)
    }

    companion object {
        @JvmStatic
        fun lottoNumbersAndMatchCount(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(listOf(1, 2, 3, 4, 5, 40), 5),
                Arguments.of(listOf(30, 2, 3, 4, 5, 40), 4),
                Arguments.of(listOf(30, 2, 3, 4, 15, 40), 3),
                Arguments.of(listOf(30, 7, 3, 4, 15, 40), 2),
                Arguments.of(listOf(30, 7, 10, 4, 15, 40), 1),
                Arguments.of(listOf(30, 7, 10, 11, 15, 40), 0),
            )
        }
    }
}
