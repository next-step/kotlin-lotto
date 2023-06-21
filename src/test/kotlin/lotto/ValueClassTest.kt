package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@JvmInline
value class LottoNumber2(private val value: Int) {
    init {
        require(value in 1..45)
    }
}

class ValueClassTest {
    @Test
    fun test() {
        val number1 = LottoNumber2(1)
        val number2 = LottoNumber2(1)
        assertThat(number1 == number2).isTrue()
    }
}
