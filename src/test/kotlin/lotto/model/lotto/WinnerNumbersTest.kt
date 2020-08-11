package lotto.model.lotto

import lotto.model.prize.Prize
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinnerNumbersTest {

    @DisplayName(value = "당첨 번호 생성시, 보너스번호는 당첨번호와 중복되거나, 로또 숫자 범위를 넘어가서는 안된다, Exception")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 0, 55])
    fun checkDuplicationBonusBall(input: Int) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                WinnerNumbers("1,2,3,4,5,6".toNumbers(), LottoNumber.from(input))
            }
    }

    @DisplayName(value = "6개의 같은 숫자일 경우, 1등")
    @Test
    fun checkMathPrizeOne() {
        val winnerNumbers = WinnerNumbers(
            Numbers(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers()),
            LottoNumber.from(7)
        )
        val lottoNumber = Numbers(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers())
        Assertions.assertThat(winnerNumbers.match(lottoNumber)).isSameAs(Prize.ONE)
    }

    @DisplayName(value = "5개의 같은 숫자, 보너스 볼도 같은 경우, 2등")
    @Test
    fun checkMathPrizeTWOBonus() {
        val winnerNumbers = WinnerNumbers(
            Numbers(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers()),
            LottoNumber.from(7)
        )
        val lottoNumber = Numbers(listOf(1, 2, 3, 4, 5, 7).toLottoNumbers())
        Assertions.assertThat(winnerNumbers.match(lottoNumber)).isSameAs(Prize.TWO_BONUS)
    }

    @DisplayName(value = "5개의 같은 숫자, 보너스 볼은 다를 경우, 3등")
    @Test
    fun checkMathPrizeTWO() {
        val winnerNumbers = WinnerNumbers(
            Numbers(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers()),
            LottoNumber.from(7)
        )
        val lottoNumber = Numbers(listOf(1, 2, 3, 4, 5, 8).toLottoNumbers())
        Assertions.assertThat(winnerNumbers.match(lottoNumber)).isSameAs(Prize.TWO)
    }

    @DisplayName(value = "같은 숫자가 2개 이하일 경우, Zero")
    @Test
    fun checkMathPrizeZero() {
        val winnerNumbers = WinnerNumbers(
            Numbers(listOf(1, 2, 3, 4, 5, 6).toLottoNumbers()),
            LottoNumber.from(7)
        )
        val lottoNumber = Numbers(listOf(1, 2, 7, 8, 9, 10).toLottoNumbers())
        Assertions.assertThat(winnerNumbers.match(lottoNumber)).isSameAs(Prize.ZERO)
    }
}
