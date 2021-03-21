package lotto.domain

import lotto.domain.lottogenerator.ManualLottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class LottosMachineTest {

    private val manualLottoGenerator1 = ManualLottoGenerator(listOf(1, 2, 3, 4, 5, 6))
    private val manualLottoGenerator2 = ManualLottoGenerator(listOf(7, 8, 9, 10, 11, 12))

    @Test
    fun `입력 금액보다 수동 로또 구매 금액이 더 큰 경우 객체 생성이 불가능하다`() {
        val money = Money(1000)
        val manualLottoGenerators = listOf(
            manualLottoGenerator1,
            manualLottoGenerator2
        )
        assertThrows<IllegalArgumentException> { LottosMachine(money, manualLottoGenerators) }
    }

    @Test
    fun `입력 금액과 수동 로또 구매 금액이 같은 경우 객체 생성이 가능하다`() {
        val money = Money(2000)
        val manualLottoGenerators = listOf(
            manualLottoGenerator1,
            manualLottoGenerator2
        )
        assertDoesNotThrow { LottosMachine(money, manualLottoGenerators) }
    }

    @Test
    fun `입력 금액에 맞는 로또개수가 나온다`() {
        val money = Money(1000)
        val lottos = LottosMachine(money).create()
        val count = money.div(Lotto.PRICE).toInt()
        assertThat(lottos.elements.size).isEqualTo(count)
    }
}
