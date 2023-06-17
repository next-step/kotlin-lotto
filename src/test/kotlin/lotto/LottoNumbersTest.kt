package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumbersTest {
    @Test
    fun `로또 번호에 중복이 있으면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)
        shouldThrow<IllegalArgumentException> { LottoNumbers.from(numbers) }
            .shouldHaveMessage(LottoNumbers.LOTTO_NUMBERS_DUPLICATE_MESSAGE)
    }

    @Test
    fun `text로 LottoNumbers를 생성할 수 있다`() {
        val text = "1, 2, 3, 4, 5, 6"
        val lottoNumbers = LottoNumbers.from(text)
        lottoNumbers.numbers shouldBe List(LottoNumbers.SIZE) { LottoNumber(it + 1) }
    }

    @ParameterizedTest
    @CsvSource("1,2,3,4,5,Z", "1a,2,3,4,5,6", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,46", "1,1,1,1,1,1", delimiter = ' ')
    fun `쉼표로 구분된 1~45 사이의 숫자 6개가 포함된 문자열이 아니면 예외가 발생한다`(text: String) {
        shouldThrow<IllegalArgumentException> { LottoNumbers.from(text) }
    }

    @Test
    fun `생성된 LottoNumbers의 숫자는 오름차순으로 정렬된다`() {
        val text = "1, 6, 3, 2, 5, 4"
        val lottoNumbers = LottoNumbers.from(text)
        lottoNumbers.numbers shouldBe List(LottoNumbers.SIZE) { LottoNumber(it + 1) }
    }
}
