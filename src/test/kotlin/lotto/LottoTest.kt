package lotto

import lotto.model.GenerateLotto
import lotto.model.Lotto
import lotto.model.Lotto.Companion.EXCEPTION_DUPLICATED_LOTTO_NUMBER
import lotto.model.Lotto.Companion.EXCEPTION_LOTTO_FORMAT
import lotto.model.LottoNumber
import lotto.model.Price
import lotto.model.Price.Companion.EXCEPTION_PRICE_FORMAT
import lotto.model.Price.Companion.EXCEPTION_PRICE_NULL
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.random.Random

class LottoTest {

    @ValueSource(ints = [1000, 5000, 100000])
    @ParameterizedTest
    @DisplayName("구매 금액을 올바르게 입력한 경우")
    fun `correct purchase amount`(price: Int) {
        val sample = Price(price)

        assertThat(sample.value).isEqualTo(price)
    }

    @ValueSource(ints = [10, -199, 134256])
    @ParameterizedTest
    @DisplayName("구매 금액을 올바르게 입력하지 않은 경우")
    fun `incorrect purchase amount`(price: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Price(price) }
            .withMessage(EXCEPTION_PRICE_FORMAT)
    }

    @NullSource
    @ParameterizedTest
    @DisplayName("구매 금액을 입력하지 않은 경우")
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
        val list =
            listOf(LottoNumber(7), LottoNumber(5), LottoNumber(1), LottoNumber(6), LottoNumber(3), LottoNumber(4))
        val lotto = Lotto(list)

        assertThat(lotto.numbers).isEqualTo(listOf(1,3,4,5,7,6))
    }

    @Test
    @DisplayName("로또가 번호가 중복되어 나오는지 확인")
    fun `duplicated lotto number`() {
        val list =
            listOf(LottoNumber(43), LottoNumber(5), LottoNumber(1), LottoNumber(39), LottoNumber(1), LottoNumber(1))

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(list) }
            .withMessage(EXCEPTION_DUPLICATED_LOTTO_NUMBER)
    }

    @Test
    @DisplayName("로또가 번호가 중복되어 나오는지 확인")
    fun `incorrect lotto number`() {
        val list =
            listOf(LottoNumber(39), LottoNumber(7), LottoNumber(5), LottoNumber(1), LottoNumber(6), LottoNumber(3), LottoNumber(4))

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(list) }
            .withMessage(EXCEPTION_LOTTO_FORMAT)
    }

    @Test
    @DisplayName("로또가 번호 범위 확인")
    fun `check lotto number range`() {
        val lottos = GenerateLotto(Price(3000)).generateLottoList()
        val randomLotto = lottos[Random.nextInt(0,2)]

        assertThat(randomLotto.numbers[Random.nextInt(0,6)].number).isBetween(1, 45)
    }
}
