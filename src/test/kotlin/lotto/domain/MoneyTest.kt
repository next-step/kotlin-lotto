package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal

internal class MoneyTest {

    @ParameterizedTest(name = "{0} 원을 생성할 수 있다")
    @ValueSource(longs = [0, 1, 10, 100])
    fun `0 또는 자연수로 돈을 생성할 수 있다 (Long)`(value: Long) {
        val result = Money(value)
        assertThat(result).isNotNull()
    }

    @ParameterizedTest(name = "{0} 원을 생성할 수 있다")
    @ValueSource(ints = [0, 1, 10, 100])
    fun `0 또는 자연수로 돈을 생성할 수 있다 (Int)`(value: Int) {
        val result = Money(value)
        assertThat(result).isNotNull()
    }

    @ParameterizedTest(name = "{0} 원을 생성할 수 없다")
    @ValueSource(ints = [-1, -10, -100])
    fun `음수인 돈을 생성할 수 없다`(value: Long) {
        val expected = "돈은 음수가 될 수 없습니다. value: $value"
        val result: IllegalArgumentException = assertThrows { Money(value) }
        assertThat(result.message).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0}원 + {1}원 = {2}원")
    @CsvSource(
        "0, 0, 0",
        "1, 0, 1",
        "100, 200, 300"
    )
    fun `덧셈 연산이 가능하다`(value1: Long, value2: Long, expected: Long) {
        val result = Money(value1) + Money(value2)
        assertThat(result).isEqualTo(Money(expected))
    }

    @ParameterizedTest(name = "{0}원 - {1}원 = {2}원")
    @CsvSource(
        "0, 0, 0",
        "2, 1, 1",
        "100, 100, 0"
    )
    fun `뺄셈 연산이 가능하다`(value1: Long, value2: Long, expected: Long) {
        val result = Money(value1) - Money(value2)
        assertThat(result).isEqualTo(Money(expected))
    }

    @ParameterizedTest
    @CsvSource(
        "0, 1",
        "100, 200"
    )
    fun `뺄셈 결과가 음수면 예외를 반환한다`(value1: Long, value2: Long) {
        val expected = "돈은 음수가 될 수 없습니다. value: ${value1 - value2}"
        val result: IllegalArgumentException = assertThrows { Money(value1) - Money(value2) }
        assertThat(result.message).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} / {1} 몫: {2}")
    @CsvSource(
        "100, 1, 100",
        "100, 20, 5",
        "12, 10, 1"
    )
    fun `나눗셈의 몫 연산이 가능하다`(value1: Long, value2: Long, expected: Int) {
        val result = Money(value1) / Money(value2)
        assertThat(result).isEqualTo(expected)
    }

    fun `나눗셈의 몫 연산 시 0으로 나누는 경우에는 예외를 반환한다`() {
        val money200 = Money(200)
        val expected = "나누는 돈이 0원입니다."
        val result: IllegalArgumentException = assertThrows { money200 / Money.EMPTY }
        assertThat(result.message).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} % {1} 나머지: {2}")
    @CsvSource(
        "0, 1, 0",
        "2, 1, 0",
        "10, 4, 2",
        "10, 15, 10"
    )
    fun `나눗셈의 나머지 연산이 가능하다`(value1: Long, value2: Long, expected: Long) {
        val result = Money(value1) % Money(value2)
        assertThat(result).isEqualTo(Money(expected))
    }

    @Test
    fun `나눗셈의 나머지 연산 시 0으로 나누는 경우에는 예외를 반환한다`() {
        val money200 = Money(200)
        val expected = "나누는 돈이 0원입니다."
        val result: IllegalArgumentException = assertThrows { money200 % Money.EMPTY }
        assertThat(result.message).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} 나누기 {1} = {2}")
    @CsvSource(
        "1, 1, 1.000000",
        "3, 2, 1.500000",
        "100, 3, 33.333333",
        "5, 3, 1.666667"
    )
    fun `소수점까지 계산하는 나눗셈이 가능하며, 6자리까지 반올림하여 계산된다`(value1: Long, value2: Long, expected: BigDecimal) {
        val result = Money(value1).rateOf(Money(value2))
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `소수점까지 계산하는 나눗셈은 0으로 나누는 경우 예외를 반환한다`() {
        val money200 = Money(200)
        val expected = "나누는 돈이 0원입니다."
        val result: IllegalArgumentException = assertThrows { money200.rateOf(Money.EMPTY) }
        assertThat(result.message).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} / {1} 몫: {2}")
    @CsvSource(
        "100, 1, 100",
        "100, 20, 5"
    )
    fun `판매가능한 로또 개수를 계산한다`(money: Long, LottoPrice: Long, expected: Int) {
        val dummyMinLottoCount = 0
        val result = Money(money).sellableLottoCount(Money(LottoPrice), dummyMinLottoCount)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1001, 1000",
        "15, 10"
    )
    fun `판매가능한 로또 개수를 계산 시 남은돈이 있는 경우 예외를 반환한다`(money: Long, lottoPrice: Long) {
        val dummyMinLottoCount = 0
        val expectedMessage = "로또 구매 후 남은 돈이 있을 수 없습니다. money: $money, lottoPrice: $lottoPrice"

        val result = assertThrows<IllegalArgumentException> {
            Money(money).sellableLottoCount(Money(lottoPrice), dummyMinLottoCount)
        }

        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @ParameterizedTest
    @CsvSource(
        "999, 1000",
        "5, 10"
    )
    fun `판매가능한 로또 개수를 계산 시 구입금액이 로또가격보다 작은 경우 예외를 반환한다`(money: Long, lottoPrice: Long) {
        val dummyMinLottoCount = 0
        val expectedMessage = "구입금액은 로또가격보다 크거나 같아야 합니다. money: $money, lottoPrice: $lottoPrice"

        val result = assertThrows<IllegalArgumentException> {
            Money(money).sellableLottoCount(Money(lottoPrice), dummyMinLottoCount)
        }

        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @ParameterizedTest
    @CsvSource(
        "2000, 1000, 3",
        "100, 10, 11"
    )
    fun `판매가능한 로또 개수를 계산 시 로또개수가 최소 로또 구매 개수보다 작은 경우 예외를 반환한다`(money: Long, lottoPrice: Long, minLottoCount: Int) {
        val expectedMessage =
            "로또를 구매하기에 부족한 금액입니다. money: $money, lottoPrice: $lottoPrice, minLottoCount: $minLottoCount"

        val result = assertThrows<IllegalArgumentException> {
            Money(money).sellableLottoCount(Money(lottoPrice), minLottoCount)
        }

        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @Test
    fun `비교 연산이 가능하다`() {
        assertAll(
            "비교 연산이 가능하다",
            { assertThat(Money(200) > Money(100)).isTrue() },
            { assertThat(Money(200) >= Money(100)).isTrue() },
            { assertThat(Money(100) >= Money(100)).isTrue() },
            { assertThat(Money(100) == Money(100)).isTrue() },
            { assertThat(Money(100) < Money(200)).isTrue() },
            { assertThat(Money(100) <= Money(200)).isTrue() },
            { assertThat(Money(200) <= Money(200)).isTrue() }
        )
    }
}
