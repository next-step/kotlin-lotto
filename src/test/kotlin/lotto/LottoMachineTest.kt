package lotto

import io.kotest.matchers.collections.shouldHaveSize
import org.junit.jupiter.api.Test

internal class LottoMachineTest {
    @Test
    internal fun `정해진 수량만큼 로또를 발급할 수 있어야한다`() {
        val sut = LottoMachine()
        val issuedLottos: IssuedLottos = sut.issue(2)
        issuedLottos.lottos shouldHaveSize 2
    }
}
