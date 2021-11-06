package lotto.usecase

import lotto.domain.model.LottoNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    private val machine = LottoMachine(
        LottoGenerator()
    )

    @ValueSource(ints = [1, 2, 3, 4, 5])
    @ParameterizedTest
    fun `자동구매요청한 개수만큼 Lotto 생성`(automaticCount: Int) {
        val lottos = machine.automaticBuy(automaticCount)

        assertEquals(automaticCount, lottos.size)
    }

    @Test
    fun `수동구매 요청한 개수만큼 Lotto 생성`() {
        val number1 = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )
        val number2 = listOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
            LottoNumber(7),
        )
        val passivityNumbers = listOf(
            number1, number2
        )

        val passivityLottos = machine.passivityBuy(passivityNumbers)

        assertEquals(2, passivityLottos.size)
    }

    @Test
    fun `수동구매 요청한 번호로 Lotto 생성`() {
        val number = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )
        val passivityNumbers = listOf(number)

        val passivityLottos = machine.passivityBuy(passivityNumbers)

        assertEquals(number, passivityLottos[0].numbers.numbers)
    }
}
