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
            .isThrownBy { Lotto(incorrect) }
    }

    @Test
    fun `로또는 1~49 사이의 숫자들이다`() {
        val incorrect = object : CreateStrategy {
            override fun createNumbers(): List<Int> {
                return listOf(0, 1, 2, 3, 4, 5)
            }
        }
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(incorrect) }
    }

    @Test
    fun `로또는 숫자들이 겹치면 안된다`() {
        val incorrect = object : CreateStrategy {
            override fun createNumbers(): List<Int> {
                return listOf(1, 1, 2, 3, 4, 5)
            }
        }
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(incorrect) }
    }

    @Test
    fun `로또는 당첨 번호랑 3개 일치하면 4등이다`() {
        val createStrategy = object : CreateStrategy {
            override fun createNumbers(): List<Int> {
                return listOf(1, 2, 3, 4, 5, 6)
            }
        }

        val lotto = Lotto(createStrategy)
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 10, 11, 12))
        Assertions.assertThat(lotto.getLottoResult(winningNumbers)).isEqualTo(LottoRank.FOURTH)
    }

    @Test
    fun `로또는 당첨 번호랑 4개 일치하면 3등이다`() {
        val createStrategy = object : CreateStrategy {
            override fun createNumbers(): List<Int> {
                return listOf(1, 2, 3, 4, 5, 6)
            }
        }

        val lotto = Lotto(createStrategy)
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 11, 12))
        Assertions.assertThat(lotto.getLottoResult(winningNumbers)).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `로또는 당첨 번호랑 5개 일치하면 2등이다`() {
        val createStrategy = object : CreateStrategy {
            override fun createNumbers(): List<Int> {
                return listOf(1, 2, 3, 4, 5, 6)
            }
        }

        val lotto = Lotto(createStrategy)
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 12))
        Assertions.assertThat(lotto.getLottoResult(winningNumbers)).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `로또는 당첨 번호랑 6개 일치하면 1등이다`() {
        val createStrategy = object : CreateStrategy {
            override fun createNumbers(): List<Int> {
                return listOf(1, 2, 3, 4, 5, 6)
            }
        }

        val lotto = Lotto(createStrategy)
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        Assertions.assertThat(lotto.getLottoResult(winningNumbers)).isEqualTo(LottoRank.FIRST)
    }
}
