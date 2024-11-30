package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [-45, -1, 0, 46])
    fun `로또 번호는 1~45 범위 내의 숫자여야 한다`(number: Int) {
        shouldThrow<IllegalArgumentException> { LottoNumber.from(number) }
            .message.shouldStartWith("로또 번호는 1~45 사이여야 합니다.")
    }

    @Test
    fun `LottoNumber가 생성된다`() {
        val number = LottoNumber.from(5)

        number shouldBe LottoNumber.from(5)
    }
}
