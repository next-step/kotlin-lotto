package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_RANGE_END
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 3, 5, 7])
    fun `당첨 숫자가 6개가 아니면 예외 발생`(size: Int) {
        val numbers = (Lotto.LOTTO_NUMBER_RANGE_START..LOTTO_NUMBER_RANGE_END).shuffled().subList(0, size).toSet()
        assertThrows<IllegalArgumentException> { WinningLotto(numbers) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `잘못된 범위의 로또 당첨 번호 입력시 예외 발생`(number: Int) {
        val numbers = mutableSetOf(1, 2, 3, 4, 5)
        numbers.add(number)
        assertThrows<IllegalArgumentException> { WinningLotto(numbers) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 5])
    fun `중복된 숫자 포함 6개 입력시 예외 발생`(number: Int) {
        val numbers = mutableSetOf(1, 2, 3, 4, 5)
        numbers.add(number)
        assertThrows<IllegalArgumentException> { WinningLotto(numbers) }
    }
}
