package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,6,7,8"])
    fun `로또 번호가 6개가 아니면 오류가 발생한다`(input: String) {
        // given
        val numbers = input.split(",").map { LottoNumber(it.toInt()) }

        // when & then
        assertThrows<IllegalArgumentException> { Lotto(numbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,5", "1,2,3,4,5,6,6", "1,2,3,4,5,6,7,7"])
    fun `로또 번호에 중복이 있으면 오류가 발생한다`(input: String) {
        // given
        val numbers = input.split(",").map { LottoNumber(it.toInt()) }

        // when & then
        assertThrows<IllegalArgumentException> { Lotto(numbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,0", "1,2,3,4,5,6,46", "1,2,3,4,5,6,7,100"])
    fun `로또 번호가 1~45 사이의 숫자가 아니면 오류가 발생한다`(input: String) {
        // given
        val numbers = input.split(",")

        // when & then
        assertThrows<IllegalArgumentException> { Lotto(numbers.map { LottoNumber(it.toInt()) }) }
    }
}
