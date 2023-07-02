package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.view.InputView.splitToIntList
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumbersTest {
    @Test
    fun `로또 번호에 중복이 있으면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)
        shouldThrow<IllegalArgumentException> { LottoNumbers.from(numbers) }
            .shouldHaveMessage(LottoNumbers.LOTTO_NUMBERS_DUPLICATE_MESSAGE.format(numbers))
    }

    @Test
    fun `Int List로 LottoNumbers를 생성할 수 있다`() {
        val lottoNumbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
        lottoNumbers.numbers.map { it.number } shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    @ParameterizedTest
    @CsvSource("1,2,3,4,5,Z", "1a,2,3,4,5,6", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,46", "1,1,1,1,1,1", delimiter = ' ')
    fun `쉼표로 구분된 1~45 사이의 숫자 6개가 포함된 문자열이 아니면 예외가 발생한다`(text: String) {
        shouldThrow<IllegalArgumentException> { LottoNumbers.from(text.splitToIntList()) }
    }

    @Test
    fun `생성된 LottoNumbers의 숫자는 오름차순으로 정렬된다`() {
        val lottoNumbers = LottoNumbers.from(listOf(1, 6, 3, 2, 5, 4))
        lottoNumbers.numbers.map { it.number } shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `LottoNumbers 끼리 얼마나 일치하는지 count를 얻을 수 있다`() {
        val lottoNumbers1 = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumbers2 = LottoNumbers.from(listOf(1, 2, 3, 4, 7, 8))

        lottoNumbers1.match(lottoNumbers2) shouldBe 4
    }

    @Test
    fun `특정 LottoNumber가 LottoNumbers에 포함되어 있는지 알 수 있다`() {
        val lottoNumbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))

        lottoNumbers.contains(LottoNumber.from(1)) shouldBe true
        lottoNumbers.contains(LottoNumber.from(7)) shouldBe false
    }
}
