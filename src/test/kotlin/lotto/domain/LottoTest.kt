package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @RepeatedTest(5)
    fun `1~45 범위의 랜덤 숫자 6개를 생성한다`() {
        assertThat(Lotto().numbers.size).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 3, 5, 7])
    fun `숫자가 6개가 아니면 예외 발생한다`(size: Int) {
        val numbers = (1..45).shuffled().subList(0, size).toSet()
        assertThrows<IllegalArgumentException> { Lotto(numbers) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `잘못된 범위의 로또 번호 입력시 예외 발생한다`(number: Int) {
        val numbers = mutableSetOf(1, 2, 3, 4, 5)
        numbers.add(number)
        assertThrows<IllegalArgumentException> { Lotto(numbers) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 5])
    fun `중복된 숫자 포함 6개 입력시 예외 발생한다`(number: Int) {
        val numbers = mutableSetOf(1, 2, 3, 4, 5)
        numbers.add(number)
        assertThrows<IllegalArgumentException> { Lotto(numbers) }
    }
}
