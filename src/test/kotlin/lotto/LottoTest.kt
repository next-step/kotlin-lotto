package lotto

import io.kotest.matchers.collections.shouldBeOneOf
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또는 6자리 숫자를 가진다`() {
        val lotto = Lotto()
        lotto.numbers.size shouldBe 6
    }

    @Test
    fun `로또는 1부터 45까지의 숫자를 가진다`() {
        val lotto = Lotto()
        lotto.numbers.forEach {
            it.shouldBeInRange(1..45)
        }
    }

    @Test
    fun `로또는 중복되지 않는 숫자를 가진다`() {
        val lotto = Lotto()
        lotto.numbers.toSet().size shouldBe 6
    }

    @Test
    fun `로또는 숫자는 오름차순 정렬`() {
        val lotto = Lotto()
        lotto.numbers shouldBe lotto.numbers.sorted()
    }

    @Test
    fun `로또 숫자는 중복되지 않는다`() {
        val lotto = Lotto()
        lotto.numbers.forEach {
            it shouldBeOneOf lotto.numbers
        }
    }
}
