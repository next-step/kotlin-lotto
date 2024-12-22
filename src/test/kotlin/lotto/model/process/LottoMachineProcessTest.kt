package lotto.model.process

import io.kotest.matchers.shouldBe
import lotto.model.price.Lotto2024Price
import lotto.model.rank.LottoWinningRank
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineProcessTest {
    @ParameterizedTest
    @ValueSource(
        strings = [
            "1000,14000",
            "2000,14000",
            "3000,14000",
        ],
    )
    fun `구입금액, 구매가능 개수 테스트`(rawInput: String) {
        val (price, purchaseAmount) =
            rawInput.split(",")
                .map { it.toInt() }

        val lottoPrice = Lotto2024Price(price)
        val lottoRank = LottoWinningRank()
        val process = LottoMachineProcess(lottoPrice, lottoRank)
        val count = process.calculateLottoCount(purchaseAmount)
        count shouldBe purchaseAmount.div(price)
    }
}
