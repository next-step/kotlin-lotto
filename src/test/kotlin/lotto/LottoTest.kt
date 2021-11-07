package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @ParameterizedTest(name = "로또는 1000money 당 1장 살 수 있다.")
    @CsvSource(value = ["1000, 1", "1500, 1", "2300, 2", "12315, 12", "9232, 9"])
    fun `로또는 1000money 당 1장 살 수 있다`(value: String, expected: Int) {
        assertThat(Lotto.getPurchasedLottoCount(Money.of(value))).isEqualTo(expected)
    }

    @ParameterizedTest(name = "Lotto에 있는 Number List의 갯수는 6개여야 한다.")
    @ValueSource(ints = [1, 2, 3, 4, 5, 7, 8])
    fun `Lotto에 있는 Number List의 갯수는 6개여야 한다`(value: Int) {
        val numberList = (1..value).map { LottoNumber.of(it) }

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Lotto.of(numberList)
        }
    }

    @DisplayName(value = "Lotto번호가 중복되면 Exception을 던진다.")
    @Test
    fun `Lotto번호가 중복되면 Exception을 던진다`() {
        val number1 = LottoNumber.of(1)
        val number2 = LottoNumber.of(2)
        val number3 = LottoNumber.of(2)
        val number4 = LottoNumber.of(3)
        val number5 = LottoNumber.of(3)
        val number6 = LottoNumber.of(3)

        val lottoNUmberList = listOf(number1, number2, number3, number4, number5, number6)

        assertThrows<IllegalArgumentException> { Lotto.of(lottoNUmberList) }
    }

    @DisplayName(value = "콤마 DELIMITER를 통해 LOTTO를 생성할 수 있다.")
    @Test
    fun `콤마 DELIMITER를 통해 LOTTO를 생성할 수 있다`() {
        val lotto = Lotto.of("1, 2, 3, 4, 5, 6")

        assertThat(lotto).isEqualTo(Lotto.of((1..6).map { LottoNumber.of(it) }))
    }
}
