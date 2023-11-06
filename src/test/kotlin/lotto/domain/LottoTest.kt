package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldHaveSize
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또는 6개의 번호만 가질 수 있다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        lotto.numbers shouldHaveSize 6
    }

    @Test
    fun `로또는 6개 보다 많게 가질 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호는 서로 다른 숫자로 이루어야한다`() {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 1, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 번호는 1~45 사이의 수이다`() {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 46, 3, 4, 5, 6, 7))
        }
    }
}
