package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_RANGE
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @Test
    fun `당첨 로또가 생성된다`() {
        val winningLotto = Lotto.createWinningLotto("1, 2, 3, 4, 5, 6")

        winningLotto shouldBe Lotto.create(listOf(1, 2, 3, 4, 5, 6))
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "1,a,c,2", "1, ", "dlfdltkatk"])
    fun `당첨 로또 번호가 숫자가 아닌 번호로 로또 생성시 예외 발생한다`(input: String) {
        shouldThrow<IllegalArgumentException> {
            Lotto.createWinningLotto(input)
        }.message.shouldContain("숫자가 아닌 문자를 입력했습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "1, 2, 3", "1, 2, 3, 4, 5, 5", "1, 1, 1, 4, 5, 5", "1, 2, 3, 4, 5, 6, 7, 8"])
    fun `당첨 로또 번호가 6개 미만이면 로또 생성시 예외 발생한다`(input: String) {
        shouldThrow<IllegalArgumentException> {
            Lotto.createWinningLotto(input)
        }.message shouldBe "로또 번호는 ${Lotto.SIZE}개여야 합니다."
    }
}
