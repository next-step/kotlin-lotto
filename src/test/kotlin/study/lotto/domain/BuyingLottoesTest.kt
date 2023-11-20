package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BuyingLottoesTest {

    @Test
    fun `getAll()은 자동구매 및 수동구매 로또들이 모두 포함되어야 한다`() {
        val autoLotto1 = Lotto(LottoNumbers.get(listOf(1, 2, 3, 4, 5, 6)))
        val autoLotto2 = Lotto(LottoNumbers.get(listOf(7, 8, 9, 10, 11, 12)))
        val manualLotto1 = Lotto(LottoNumbers.get(listOf(13, 14, 15, 16, 17, 18)))
        val manualLotto2 = Lotto(LottoNumbers.get(listOf(19, 20, 21, 22, 23, 24)))

        val buyingAuto = Lottoes(listOf(autoLotto1, autoLotto2))
        val buyingManual = Lottoes(listOf(manualLotto1, manualLotto2))

        val buyingLottoes = BuyingLottoes(buyingAuto, buyingManual)

        val allLottoes = buyingLottoes.getAll()
        assertEquals(4, allLottoes.size)
        assertEquals(listOf(autoLotto1, autoLotto2, manualLotto1, manualLotto2), allLottoes)
    }
}
