package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers
import lotto.domain.LottoNumber
import org.junit.jupiter.api.Test

class LottoNumbersNumbersTest {

    @Test
    fun `로또는 6개의 로또 번호를 가진다`() {
        val lottoNumbers = LottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )

        lottoNumbers.getNumbers().size shouldBe 6
    }

    @Test
    fun `로또 번호는 6개여야만 한다`() {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(listOf(LottoNumber(1)))
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
        val lottoNumbers = LottoNumbers(
            numbers
        )

        lottoNumbers.getNumbers().shouldContainInOrder(
            orderNumbers
        )
    }
}
