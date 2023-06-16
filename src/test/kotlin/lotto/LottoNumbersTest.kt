package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumbersTest {
    @Test
    fun `로또 번호에 중복이 있으면 예외가 발생한다`() {
        val numbers = listOf(1,2,3,4,5,5).map { LottoNumber(it) }
        shouldThrow<IllegalArgumentException> { LottoNumbers(numbers) }
            .shouldHaveMessage(LottoNumbers.LOTTO_NUMBERS_DUPLICATE_MESSAGE)
    }

    @ParameterizedTest
    @CsvSource("1,2,3,4,5", "1,2,3,4,5,6,7", delimiter = ' ')
    fun `로또 번호는 6개의 숫자로 이루어진다 그렇지 않으면 예외가 발생한다`(text: String) {
        val numbers = text.split(",").map { LottoNumber(it.toInt()) }
        shouldThrow<IllegalArgumentException> { LottoNumbers(numbers) }
            .shouldHaveMessage(LottoNumbers.LOTTO_NUMBERS_INVALID_SIZE_MESSAGE)
    }
}