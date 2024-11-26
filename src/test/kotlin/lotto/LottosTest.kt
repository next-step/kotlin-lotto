package lotto

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import lotto.number.Numbers
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `로또 번호 중복이 있으면 예외를 던진다`() {
        shouldThrow<IllegalArgumentException> { Lottos(lottos = listOf(firstLotto, firstLotto)) }
    }

    @Test
    fun `로또 번호 중복이 있으면 예외를 던지지 않는다`() {
        shouldNotThrow<IllegalArgumentException> { Lottos(lottos = listOf(firstLotto, secondLotto)) }
    }

    companion object {
        private val firstLotto = Lotto(numbers = Numbers.fromInts(listOf(1, 2, 3, 4, 5, 6)))
        private val secondLotto = Lotto(numbers = Numbers.fromInts(listOf(1, 2, 4, 5, 6, 7)))
    }
}