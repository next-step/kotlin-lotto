package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.generator.LottoNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `요청한 개수만큼 로또를 발급한다`() {
        val lotto = LottoMachine.make(6, TestLottoNumberGenerator)
        Assertions.assertThat(lotto.size).isEqualTo(6)
    }
}

object TestLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(count: Int): List<LottoNumber> {
        return listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)
    }
}
