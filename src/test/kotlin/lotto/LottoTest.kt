package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldContainExactly
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    internal fun `로또는 6개의 번호를 가진다`() {
        val sut = Lotto(setOf(1, 2, 3, 4, 5, 6))
        sut.numbers shouldContainExactly setOf(1, 2, 3, 4, 5, 6)
    }

    @Test
    internal fun `로또가 6개의 번호를 가지지 않으면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { Lotto(setOf(1, 2, 3, 4, 5)) }
    }

    @Test
    internal fun `로또 번호가 1부터 45사이의 값이 아닌 경우 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { Lotto(setOf(-1, 0, 1, 20, 45, 46)) }
    }

    @Test
    internal fun `로또 번호가 서로 중복되는 경우 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { Lotto(setOf(3, 3, 17, 20, 40, 45)) }
    }
}
