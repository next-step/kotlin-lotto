package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @ParameterizedTest(name = "로또는 1000money 당 1장 살 수 있다.")
    @CsvSource(value = ["1000, 1", "1500, 1", "2300, 2", "12315, 12", "9232, 9"])
    fun `로또는 1000money 당 1장 살 수 있다`(value: String, expected: Int) {
        Assertions.assertThat(Money.of(value).lottoCount).isEqualTo(expected)
    }

    @ParameterizedTest(name = "Lotto에 있는 Number List의 갯수는 6개여야 한다.")
    @ValueSource(ints = [1, 2, 3, 4, 5, 7, 8])
    fun `Lotto에 있는 Number List의 갯수는 6개여야 한다`(value: Int) {
        val numberList = (1..value).map { LottoNumber(it) }

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Lotto.of(numberList)
        }.withMessage("로또 숫자의 갯수는 ${Lotto.LOTTO_SIZE}여야 합니다.")
    }

    @Test
    fun `Lotto번호가 중복되면 Exception을 던진다`() {
        val number1 = LottoNumber(1)
        val number2 = LottoNumber(2)
        val number3 = LottoNumber(2)
        val number4 = LottoNumber(3)
        val number5 = LottoNumber(3)
        val number6 = LottoNumber(3)

        val lottoNUmberList = listOf(number1, number2, number3, number4, number5, number6)

        assertThrows<IllegalArgumentException> { Lotto.of(lottoNUmberList) }
    }
}
