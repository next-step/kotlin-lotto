package lotto

import io.kotest.assertions.throwables.shouldThrow
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoTickets
import lotto.domain.ManualLottoCount
import lotto.domain.PurchaseAmount
import lotto.domain.dto.PurchaseLottoRequest
import org.junit.jupiter.api.Test

private fun Array<Int>.toLotto(): Lotto = Lotto(map(::LottoNumber))

class LottoStoreTest {
    @Test
    fun `1000원 미만의 금액을 입력하면 예외를 리턴한다`() {
        shouldThrow<IllegalArgumentException> {
            PurchaseAmount(999)
        }
    }

    @Test
    fun `수동 로또 수에 0보다 작은 값이 들어오면 예외를 리턴한다`() {
        shouldThrow<IllegalArgumentException> {
            ManualLottoCount(-3)
        }
    }

    @Test
    fun `수동 로또를 구매할 금액이 부족할 경우 예외를 리턴한다`() {
        val purchaseAmount = PurchaseAmount(2000)
        val manualLottoCount = ManualLottoCount(3)
        val manualLottoTickets = LottoTickets(
            listOf(
                arrayOf(1, 2, 3, 4, 5, 6).toLotto(),
                arrayOf(1, 2, 3, 4, 5, 6).toLotto(),
                arrayOf(1, 2, 3, 4, 5, 6).toLotto(),
            )
        )

        shouldThrow<IllegalArgumentException> {
            PurchaseLottoRequest(
                purchaseAmount,
                manualLottoCount,
                manualLottoTickets
            )
        }
    }
}