package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class LottoTest {

    @Test
    fun `로또는 6개의 숫자로 이뤄져 있다`() {
        val incorrect = object : CreateStrategy {
            override fun createNumbers(): List<Int> {
                return listOf(1, 2, 3, 4, 5, 6, 7)
            }
        }
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(LottoNumbers(incorrect)) }
    }

    @Test
    fun `로또는 1~49 사이의 숫자들이다`() {
        val incorrect = object : CreateStrategy {
            override fun createNumbers(): List<Int> {
                return listOf(0, 1, 2, 3, 4, 5)
            }
        }
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(LottoNumbers(incorrect)) }
    }

    @Test
    fun `로또는 숫자들이 겹치면 안된다`() {
        val incorrect = object : CreateStrategy {
            override fun createNumbers(): List<Int> {
                return listOf(1, 1, 2, 3, 4, 5)
            }
        }
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(LottoNumbers(incorrect)) }
    }
}
