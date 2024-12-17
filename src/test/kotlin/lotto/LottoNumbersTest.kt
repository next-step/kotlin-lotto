package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    @Test
    fun `로또 번호 개수가 6개가 아니면 예외를 발생한다`() {
        assertThatThrownBy { LottoNumbers.from(listOf(1)) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `일치하는 로또 번호가 있는지 확인할 수 있다`() {
        val lottoNumbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumber = LottoNumber.from(1)

        lottoNumbers.contains(lottoNumber) shouldBe true
    }

    @Test
    fun `일치하는 로또 번호 개수를 확인할 수 있다`() {
        val lottoNumbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
        val winnerNumbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 7))

        lottoNumbers.countMatches(winnerNumbers) shouldBe 5
    }
}
