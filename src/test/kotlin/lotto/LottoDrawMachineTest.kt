package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class LottoDrawMachineTest {
    @Test
    fun `추출할 번호들을 입력받을 수 있다`() {
        LottoDrawMachine(1..45)
    }

    @Test
    fun `번호는 45개이다`() {
        assertThat(LottoDrawMachine(1..45).size).isEqualTo(45)
    }

    @Test
    fun `45개 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { LottoDrawMachine((1..44).toSet() + setOf(1)) }
    }

    @Test
    fun `로또 번호를 생성한다`() {
        LottoDrawMachine(1..45).lottoNumber()
    }

    @Test
    fun `로또 번호는 6개 이다`() {
        assertAll(
            {
                LottoNumber((1..6))
            },
            {
                assertThrows<IllegalArgumentException> { LottoNumber((1..5)) }
            },
            {
                assertThrows<IllegalArgumentException> { LottoNumber((1..7)) }
            }
        )
    }

    class LottoDrawMachine(private val pool: Set<Int>) {
        val size: Int = pool.size

        init {
            require(size == POOL_SIZE)
        }

        constructor(range: IntRange) : this(range.toSet())

        fun lottoNumber(): LottoNumber = pool.shuffled()
            .toSet()
            .let { LottoNumber.from(it) }

        companion object {
            const val POOL_SIZE: Int = 45
        }
    }

    data class LottoNumber(private val numbers: List<Int>) {
        val size: Int = numbers.size

        init {
            require(numbers.toSet().size == BALL_COUNT)
        }

        constructor(range: IntRange) : this(range.toList())

        companion object {
            const val BALL_COUNT: Int = 6

            fun from(source: Set<Int>): LottoNumber {
                return LottoNumber(source.take(BALL_COUNT))
            }
        }
    }
}
