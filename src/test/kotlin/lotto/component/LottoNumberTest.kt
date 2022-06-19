package lotto.component

import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46, 100])
    fun `1미만 45초과면 예외`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(number) }
            .shouldHaveMessage("로또 숫자는 1 부터 45 사이여야 합니다.")
    }
}
