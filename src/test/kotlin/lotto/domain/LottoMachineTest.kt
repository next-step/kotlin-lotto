package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.number.LottoNumber
import lotto.domain.number.LottoNumberGenerator
import lotto.domain.number.LottoNumberResult
import lotto.domain.purchase.LottoBuyingPrice
import lotto.domain.purchase.LottoBuyingPriceResult
import lotto.domain.result.LottoRank

class LottoMachineTest : StringSpec({

    "로또 당첨 번호를 받아 로또 결과를 반환한다." {
        // given
        val autoLottoCount = 2
        val lottoMachine = createLottoMachine(autoLottoCount)

        val lottoResult = Lotto.createFromNumbers(listOf(2, 3, 6, 7, 8, 9))
        val winningLottoNumbers = lottoResult as LottoResult.Success

        val lottoNumberResult = LottoNumber.createResult(10)
        val bonusBall = lottoNumberResult as LottoNumberResult.Success

        val priceResult = LottoBuyingPrice.createResult(2000)
        val buyingPrice = priceResult as LottoBuyingPriceResult.Success

        val winningLottoResult = WinningLotto.createResult(winningLottoNumbers.data, bonusBall.data)
        val winningLotto = winningLottoResult as WinningLottoResult.Success

        // when
        val lottoMatchResult = lottoMachine.getResult(winningLotto.data, buyingPrice.data)

        // then
        lottoMatchResult.result shouldBe mutableMapOf(
            LottoRank.FIFTH to 2
        )
        lottoMatchResult.earningRate shouldBe 5.0
    }
})

private fun createLottoMachine(autoLottoCount: Int): LottoMachine {
    return LottoMachine.of(
        autoLottoCount = autoLottoCount,
        lottoNumberGenerator = createFakeNumberGenerator(),
        manualLotto = emptyList()
    )
}

private fun createFakeNumberGenerator() = object : LottoNumberGenerator {
    override fun generate(count: Int): List<LottoNumber> {
        return List(6) {
            (LottoNumber.createResult(it + 1) as LottoNumberResult.Success).data
        }
    }
}
