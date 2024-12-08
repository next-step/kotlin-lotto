package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lotto.model.Lotto
import lotto.model.LottoNumber
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `6개의 고유 번호로 이루어져 있다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.from(lottoNumbers)
        lotto.getNumbers().map { it.num } shouldBe lottoNumbers.sorted()
    }

    @Test
    fun `6개가 아니면 예외를 던진다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5)
        val exception =
            shouldThrow<IllegalArgumentException> {
                Lotto.from(lottoNumbers)
            }
        exception.message shouldBe "중복되지 않는 로또 번호 6개를 입력해주세요"
    }

    @Test
    fun `자동 생성된 로또는 6개의 고유한 번호를 가진다`() {
        val lotto = Lotto.fromAuto()
        val numbers = lotto.getNumbers()
        numbers.map { it.num }.distinct() shouldHaveSize 6
    }

    @Test
    fun `당첨 번호와 일치하는 개수를 계산한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }

        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        lotto.countMatchingNumbers(winningNumbers) shouldBe 6

        val lotto2 = Lotto.from(listOf(1, 2, 3, 4, 5, 7))
        lotto2.countMatchingNumbers(winningNumbers) shouldBe 5

        val lotto3 = Lotto.from(listOf(1, 2, 3, 4, 8, 9))
        lotto3.countMatchingNumbers(winningNumbers) shouldBe 4

        val lotto4 = Lotto.from(listOf(1, 2, 3, 10, 11, 12))
        lotto4.countMatchingNumbers(winningNumbers) shouldBe 3

        val lotto5 = Lotto.from(listOf(1, 2, 13, 14, 15, 16))
        lotto5.countMatchingNumbers(winningNumbers) shouldBe 2
    }
}
