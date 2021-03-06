package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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
    fun `6자리 번호를 생성한다`() {
        assertThat(LottoDrawMachine(1..45).balls().size).isEqualTo(6)
    }

    class LottoDrawMachine(private val pool: Set<Int>) {
        val size: Int = pool.size

        init {
            require(size == 45)
        }

        constructor(range: IntRange) : this(range.toSet())

        fun balls(): Set<Int> = pool.shuffled()
            .subList(0, 6)
            .toSet()
    }
}
