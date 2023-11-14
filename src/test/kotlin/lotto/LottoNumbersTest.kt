package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    @Test
    fun `로또는 6개의 로또 번호를 가진다`() {
        val lotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )

        lotto.getNumbers().size shouldBe 6
    }

    @Test
    fun `로또 번호는 6개여야만 한다`() {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(LottoNumber(1)))
        }
    }

    @Test
    fun `로또의 숫자는 정렬되어있다`() {
        val numbers = listOf(
            LottoNumber(6),
            LottoNumber(5),
            LottoNumber(4),
            LottoNumber(3),
            LottoNumber(2),
            LottoNumber(1),
        )
        val orderNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )
        val lotto = Lotto(
            numbers
        )

        lotto.getNumbers().shouldContainInOrder(
            orderNumbers
        )
    }

    @Test
    fun `data class에서 copy()시 equals 테스트`() {
        val number1 = LottoNumber(1)
        val copyNumber1 = number1.copy()

        (number1 == copyNumber1) shouldBe true
        (number1 == LottoNumber(1)) shouldBe true
    }
}
