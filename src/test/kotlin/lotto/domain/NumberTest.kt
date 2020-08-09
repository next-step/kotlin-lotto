package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NumberTest {

    @Test
    fun can_has_1_to_45() {
        assertThatThrownBy {
            Number.getNumber(46)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("46는 로또 번호안에 있지 않습니다.")
    }

    @Test
    fun has_1_to_45() {
        for (number in 1..45) {
            Number.getNumber(number)
        }
    }
}
