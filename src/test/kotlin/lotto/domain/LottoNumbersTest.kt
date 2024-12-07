package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.equals.shouldBeEqual
import lotto.domain.LottoNumbers.Companion.INVALID_LOTTO_NUMBER_COUNT_MESSAGE
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoNumbersTest {
    @Test
    fun `로또 번호가 6개로 이루어지지 않으면 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_NUMBER_COUNT_MESSAGE) {
            LottoNumbers(1, 2, 3, 4, 5)
        }
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_NUMBER_COUNT_MESSAGE) {
            LottoNumbers(1, 2, 3, 4, 5, 6, 7)
        }
    }

    @MethodSource("LottoNumbers, 매칭 테스트 LottoNumbers, 매칭 결과 제공")
    @ParameterizedTest
    fun `로또 번호들을 토대로 몇개의 로또 번호가 일치하는지 확인할 수 있다`(
        lottoNumbers: LottoNumbers,
        checkLottoNumbers: LottoNumbers,
        resultMatchCount: Int,
    ) {
        lottoNumbers.checkLottoNumbersMatch(checkLottoNumbers) shouldBeEqual resultMatchCount
    }

    fun `LottoNumbers, 매칭 테스트 LottoNumbers, 매칭 결과 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(7, 8, 9, 10, 11, 12), 0),
            Arguments.of(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(6, 7, 8, 9, 10, 11), 1),
            Arguments.of(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(5, 6, 7, 8, 9, 10), 2),
            Arguments.of(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(4, 5, 6, 7, 8, 9), 3),
            Arguments.of(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(3, 4, 5, 6, 7, 8), 4),
            Arguments.of(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(2, 3, 4, 5, 6, 7), 5),
            Arguments.of(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(1, 2, 3, 4, 5, 6), 6),
        )
    }
}
