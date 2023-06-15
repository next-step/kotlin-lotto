package lotto

import lotto.domain.BillSlot
import lotto.domain.LottoNumbers
import lotto.domain.LottoVendingMachine
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTest {
    @ParameterizedTest
    @CsvSource(
        "14000, 1000, 14",
        "1300, 1000, 1",
        "1000, 2000, 0",
    )
    fun `주어진 금액으로 구입할 수 있는 로또 개수 구하기 테스트`(money: Int, lottoPrice: Int, numOfLotto: Int) {
        val billSlot = BillSlot(lottoPrice = lottoPrice)
        assertThat(billSlot.insertMoney(money))
            .isEqualTo(numOfLotto)
    }

    @Test
    fun `발급된 로또 번호는 6개여야 한다`() {
        assertThat(
            LottoNumbers.generate()
                .numbers
                .size
        ).isEqualTo(6)
    }

    @ParameterizedTest
    @CsvSource(
        "14000, 1000, 14",
        "1300, 1000, 1",
        "1000, 2000, 0",
    )
    fun `금액에 맞는 개수 만큼 로또 번호를 생성해야 한다`(money: Int, lottoPrice: Int, numOfLotto: Int) {
        assertThat(
            LottoVendingMachine(BillSlot(lottoPrice))
                .purchase(money)
                .size
        ).isEqualTo(numOfLotto)
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있다면 throw IllegalArgumentException`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(listOf(1, 1, 2, 3, 4, 5))
        }
    }

    @ParameterizedTest
    @MethodSource("범위를 벗어난 숫자가 있는 로또 번호")
    fun `로또 번호에 범위를 벗어난 숫자가 있다면 throw IllegalArgumentException`(lottoNumbers: List<Int>) {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(lottoNumbers)
        }
    }

    @ParameterizedTest
    @MethodSource("숫자가 6개가 아닌 로또 번호")
    fun `로또 번호가 6개가 아니라면 throw IllegalStateException`(lottoNumbers: List<Int>) {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(lottoNumbers)
        }
    }

    companion object {
        @JvmStatic
        fun `범위를 벗어난 숫자가 있는 로또 번호`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(-1, 1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 46)),
            )
        }

        @JvmStatic
        fun `숫자가 6개가 아닌 로또 번호`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
            )
        }
    }
}
