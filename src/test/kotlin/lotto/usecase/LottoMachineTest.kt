package lotto.usecase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    private val machine = LottoMachine(
        LottoNumberGenerator()
    )

    @ValueSource(ints = [1000, 2000, 3000, 4000, 5000])
    @ParameterizedTest
    fun `구매금액 1000원당 1장구매`(purchaseAmount: Int) {
        val expected = purchaseAmount / 1000
        val lottos = machine.buy(purchaseAmount)

        assertEquals(expected, lottos.size)
    }
}
