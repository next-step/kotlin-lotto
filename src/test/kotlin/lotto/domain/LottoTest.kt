package lotto.domain

import lotto.tokenizeWinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `당첨 번호가 6개가 아닌 경우 Exception을 던진다`(input: String) {
        val numbers = tokenizeWinningNumbers(input)
        assertThatThrownBy { Lotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 6개여야 합니다.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `당첨 번호와 매칭되는 갯수를 반환한다`(matchNum: Int) {
        val numbers = mutableListOf<LottoNumber>()
        (1..matchNum).forEach { numbers.add(LottoNumber.from(it)) }
        repeat(Lotto.NUMBER_NUM - numbers.size) {
            numbers.add(LottoNumber.from(TEST_LOTTO_UPPER_BOUND + 1))
        }

        val winningLotto = Lotto(numbers)
        assertThat(defaultLotto.matches(winningLotto)).isEqualTo(matchNum)
    }

    @Test
    fun `특정 번호 포함 여부를 반환한다`() {
        assertThat(defaultLotto.contains(LottoNumber.from(2))).isTrue()
        assertThat(defaultLotto.contains(LottoNumber.from(5))).isTrue()
        assertThat(defaultLotto.contains(LottoNumber.from(7))).isFalse()
    }

    companion object {
        val TEST_LOTTO_UPPER_BOUND = 6
        val defaultLotto = Lotto(tokenizeWinningNumbers("1,2,3,4,5,6"))
    }
}
