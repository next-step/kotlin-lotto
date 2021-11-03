package lotto

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.Price
import lotto.model.Price.Companion.EXCEPTION_PRICE_FORMAT
import lotto.model.Price.Companion.EXCEPTION_PRICE_NULL
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @CsvSource(value = ["1000,1", "5000,5", "10000,10"])
    @ParameterizedTest
    @DisplayName("구매 금액에 따른 로또 생성 갯수 확인")
    fun `correct purchase amount`(price: Int, expected: Int) {
        val sample = Price(price)

        assertThat(sample.lottoCount).isEqualTo(expected)
    }

    @ValueSource(ints = [10, -199, 134256])
    @ParameterizedTest
    @DisplayName("구매 금액의 범위에 맞지 않는 숫자가 입력된 경우")
    fun `incorrect purchase amount`(price: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Price(price) }
            .withMessage(EXCEPTION_PRICE_FORMAT)
    }

    @NullSource
    @ParameterizedTest
    @DisplayName("구매 금액에 null이 입력된 경우")
    fun `null of purchase amount`(price: Int?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Price(price) }
            .withMessage(EXCEPTION_PRICE_NULL)
    }

    @ValueSource(ints = [1000, 5000, 100000])
    @ParameterizedTest
    @DisplayName("입력한 금액에 맞게 로또의 개수가 만들어졌는지 확인")
    fun `check lotto count`(price: Int) {
        val sample = Price(price)

        assertThat(sample.lottoCount).isEqualTo(price / 1000)
    }

    // 로또 객체 테스트 코드
    @Test
    @DisplayName("로또가 번호 순서대로 정렬되어 나오는지 확인")
    fun `check lotto number sorting`() {
        // given
        val list =
            listOf(
                LottoNumber(7),
                LottoNumber(5),
                LottoNumber(1),
                LottoNumber(6),
                LottoNumber(3),
                LottoNumber(4)
            )

        // when
        val lotto = Lotto(list)

        // then
        assertThat(lotto.numbers).isEqualTo(listOf(1, 3, 4, 5, 6, 7))
    }
}
