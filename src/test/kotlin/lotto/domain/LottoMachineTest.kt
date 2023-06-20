package lotto.domain

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
            val lottos = lottoMachine.buyAuto(cost)
            lottos.size shouldBe count
        }
    }
})
