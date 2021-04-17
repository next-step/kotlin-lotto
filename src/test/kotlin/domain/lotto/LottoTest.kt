package domain.lotto

import domain.money.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoTest {
    @ParameterizedTest(name = "{0}과 {1},{2},{3},{4},{5},{6}로 생성된 로또는 숫자열과 선택타입을 그대로 반환한다")
    @CsvSource(
        "AUTO,1,2,3,4,5,6",
        "MANUAL,9,8,7,6,5,4"
    )
    fun `로또는 로또숫자열 하나와 선택타입으로 생성된다`(pickType: PickType, n1: Int, n2: Int, n3: Int, n4: Int, n5: Int, n6: Int) {
        val numbers = lottoNumberOf(n1, n2, n3, n4, n5, n6)
        val lotto = Lotto(numbers, pickType)

        assertAll(
            { assertThat(lotto.numbers).isEqualTo(lottoNumberOf(n1, n2, n3, n4, n5, n6)) },
            { assertThat(lotto.pickType).isEqualTo(pickType) }
        )
    }

    @Test
    fun `선택타입없이 생성하면 선택타입은 수동이 기본이다`() {
        val lotto = Lotto(lottoNumberOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.pickType).isEqualTo(PickType.MANUAL)
    }

    @ParameterizedTest
    @CsvSource(
        "'1:2:3:4:5:6', 6",
        "'2:3:4:5:6:7', 5",
        "'3:4:5:6:7:8', 4",
        "'4:5:6:7:8:9', 3",
        "'5:6:7:8:9:10', 2",
        "'6:7:8:9:10:11', 1",
        "'7:8:9:10:11:12', 0"
    )
    fun `다른 로또숫자열을 받아, 자신의 로또숫자열과 일치하는 수가 몇 개인지 반환한다`(numbers: String, numberOfMatched: Int) {
        val winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6)
        val lotto = parseLotto(numbers)
        assertThat(lotto.countMatchedBy(winningNumbers)).isEqualTo(numberOfMatched)
    }

    @Test
    fun `로또의 가격은 1000원이다`() {
        assertThat(Lotto.PRICE).isEqualTo(Money(1000))
    }

    private fun parseLotto(numbers: String): Lotto {
        return numbers.split(":")
            .map { LottoNumber.parse(it.toInt()) }
            .let { Lotto(LottoNumbers.fromList(it)) }
    }
}
