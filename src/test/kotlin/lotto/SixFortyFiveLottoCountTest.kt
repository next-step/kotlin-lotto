package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoCount
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class SixFortyFiveLottoCountTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 10])
    fun `로또 숫자는 0 이상의 정수를 가질 수 있습니다`(count: Int) {
        val lottoCount = SixFortyFiveLottoCount(count)

        lottoCount.value shouldBe count
    }

    @Test
    fun `로또 숫자가 음의정수이면 에러를 반환합니다`() {
        val count = -1

        shouldThrow<IllegalArgumentException> { SixFortyFiveLottoCount(count) }
            .message shouldBe (ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_COUNT.msg)
    }
}
