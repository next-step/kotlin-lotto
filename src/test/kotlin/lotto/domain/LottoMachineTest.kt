package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.util.NumberGenerator

class LottoMachineTest : StringSpec({

    "구입한 로또의 금액을 계산한다." {
        // given
        val lottoCount = 10

        // when
        val lottoMachine = createLottoMachine(lottoCount)

        // then
        lottoMachine.getLottoTotalPrice() shouldBe Price(10000)
    }

    "로또 당첨 번호를 받아 로또 결과를 반환한다." {
        // given
        val lottoCount = 2
        val lottoMachine = createLottoMachine(lottoCount)
        val winningLotto = Lotto.from(listOf(2, 3, 6, 7, 8, 9))

        // when
        val lottoResult = lottoMachine.getResult(winningLotto, LottoBuyingPrice(2000), bonusBall)

        // then
        lottoResult.result shouldBe mutableMapOf(
            LottoRank.FIFTH to 2,
        )
        lottoResult.earningRate shouldBe 5.0
    }
},)

private fun createLottoMachine(lottoCount: Int): LottoMachine {
    return LottoMachine.of(
        lottoCount = lottoCount,
        numberGenerator = createFakeNumberGenerator(),
    )
}

private fun createFakeNumberGenerator() = object : NumberGenerator {
    override fun generate(min: Int, max: Int, count: Int): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}
