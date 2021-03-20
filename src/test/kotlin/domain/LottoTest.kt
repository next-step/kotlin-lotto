package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoTest {
    @Test
    fun `로또는 로또숫자열 하나로 생성된다`() {
        assertDoesNotThrow { Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)) }
    }

    @Test
    fun `로또는 숫자 6개로도 생성된다`() {
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6))
            Lotto(1, 2, 3, 4, 5, 6)
        }
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
        val winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val lotto = parseLotto(numbers)
        assertThat(lotto.countMatchedBy(winningNumbers)).isEqualTo(numberOfMatched)
    }

    @Test
    fun `로또의 가격은 1000원이다`() {
        assertThat(Lotto.PRICE).isEqualTo(Money(1000))
    }

    private fun parseLotto(numbers: String): Lotto {
        return numbers.split(":")
            .map { it.toInt() }
            .let { Lotto(it) }
    }
}
