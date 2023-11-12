package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.number.LottoNumber
import lotto.domain.number.LottoNumberGenerator
import lotto.domain.purchase.LottoBuyingPrice
import lotto.domain.result.LottoRank

class LottoMachineTest : StringSpec({

    "로또 당첨 번호를 받아 로또 결과를 반환한다." {
        // given
        val lottoCount = 2
        val lottoMachine = createLottoMachine(lottoCount)
        val winningLottoNumbers = Lotto.createFromNumbers(listOf(2, 3, 6, 7, 8, 9))
        val bonusBall = LottoNumber.from(10)
        val buyingPrice = LottoBuyingPrice(2000)
        val winningLotto = WinningLotto(winningLottoNumbers, bonusBall)

        // when
        val lottoResult = lottoMachine.getResult(winningLotto, buyingPrice)

        // then
        lottoResult.result shouldBe mutableMapOf(
            LottoRank.FIFTH to 2
        )
        lottoResult.earningRate shouldBe 5.0
    }
})

private fun createLottoMachine(lottoCount: Int): LottoMachine {
    return LottoMachine.of(
        lottoCount = lottoCount,
        lottoNumberGenerator = createFakeNumberGenerator()
    )
}

private fun createFakeNumberGenerator() = object : LottoNumberGenerator {
    override fun generate(count: Int): List<LottoNumber> {
        return List(6) { LottoNumber.from(it + 1) }
    }
}
