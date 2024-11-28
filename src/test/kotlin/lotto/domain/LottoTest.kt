package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_RANGE
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 번호는 중복될 수 없으며 6개의 번호로 구성되어야 한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.create(numbers)

        lotto.numbers.size shouldBe Lotto.SIZE
        lotto.numbers.distinct().size shouldBe Lotto.SIZE
    }

    @Test
    fun `로또 번호 자동 생성 시 번호는 1~45 사이여야 한다`() {
        val lotto = Lotto.generateAuto()

        lotto.numbers.size shouldBe Lotto.SIZE
        lotto.numbers.all { it.value in LOTTO_NUMBER_RANGE } shouldBe true
    }
}
