package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTest {
    @Test
    fun `로또번호의 갯수는 항상 6개여야 한다`() {
        val lotto1 = Lotto.create()
        val lotto2 = Lotto.create()
        val lotto3 = Lotto.create()

        assertThat(lotto1.numbers.size).isEqualTo(6)
        assertThat(lotto2.numbers.size).isEqualTo(6)
        assertThat(lotto3.numbers.size).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 7, 8, 9, 10, 11])
    fun `로또번호를 생성 할 때 번호 개수가 6개에 만족하지 않으면 예외가 발생한다`(numberSize: Int) {
        assertThrows<IllegalArgumentException> {
            Lotto.from((1..numberSize).map { LottoNumber.from(it) })
        }
    }
}