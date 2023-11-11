package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.util.NumberGenerator

class LottoMachineTest : StringSpec({

    "로또 당첨 번호와 보너스 볼이 중복되면 예외가 발생한다." {
        listOf(2, 3, 6, 7, 8, 9).forEach { number ->
            // given
            val lottoCount = 2
            val lottoMachine = createLottoMachine(lottoCount)
            val winningLotto = Lotto.from(listOf(2, 3, 6, 7, 8, 9))
            val bonusBall = LottoNumber.from(number)
            val buyingPrice = LottoBuyingPrice(2000)

            // exepcted
            shouldThrowWithMessage<IllegalArgumentException>("보너스 볼은 당첨 번호와 중복될 수 없습니다.") {
                lottoMachine.getResult(winningLotto, buyingPrice, bonusBall)
            }
        }
    }

    "로또 당첨 번호를 받아 로또 결과를 반환한다." {
        // given
        val lottoCount = 2
        val lottoMachine = createLottoMachine(lottoCount)
        val winningLotto = Lotto.from(listOf(2, 3, 6, 7, 8, 9))
        val bonusBall = LottoNumber.from(10)
        val buyingPrice = LottoBuyingPrice(2000)

        // when
        val lottoResult = lottoMachine.getResult(winningLotto, buyingPrice, bonusBall)

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
    override fun generate(count: Int): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}
