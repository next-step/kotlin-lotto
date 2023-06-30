package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `6개가 아닌 숫자를 주면 IllegalArgumentException throw`() {
        val numbers = listOf(1, 2, 3, 4, 5)

        shouldThrow<IllegalArgumentException> {
            Lotto.from(numbers)
        }
    }

    @Test
    fun `중복된 기본 숫자가 주면 IllegalArgumentException throw`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        shouldThrow<IllegalArgumentException> {
            Lotto.from(numbers)
        }
    }

    @Test
    fun `발급된 로또 번호가 오름차순으로 정렬이 되어있어야한다`() {
        val numbers = listOf(10, 2, 31, 4, 5, 26)
        val lotto = Lotto.from(numbers)

        lotto.numbers shouldBe numbers.sorted()
    }

    @Test
    fun `일치하는 숫자의 개수를 판단한다`() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        val otherNumbers = Lotto.from(listOf(4, 5, 6, 7, 8, 9))

        lotto.countMatch(otherNumbers) shouldBe 3
    }
}
