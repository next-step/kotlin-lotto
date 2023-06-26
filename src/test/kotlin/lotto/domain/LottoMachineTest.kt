package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumberSupports.toLottoNumbers

class LottoMachineTest : FreeSpec({

    "돈을 넣으면 자동으로 로또를 발급한다.(1000원)" - {
        withData(
            10000 to 10,
            5000 to 5,
            20000 to 20
        ) { (cost, count) ->
            val lottoMachine = LottoMachine { -> Lotto((1..6).toLottoNumbers()) }
            val lottos = lottoMachine.buy(LottoBuy(cost))
            lottos.size shouldBe count
        }
    }

    "금액보다 많은 수동을 입력할 수 없다." {
        val lottoMachine = LottoMachine { -> Lotto((1..6).toLottoNumbers()) }
        val lottoBuy = LottoBuy(
            2000,
            listOf(
                (1..6).toList(),
                (1..6).toList(),
                (1..6).toList()
            )
        )

        val throws = shouldThrow<IllegalArgumentException> { lottoMachine.buy(lottoBuy) }
        throws.message shouldBe "비용이 부족합니다."
    }
})
