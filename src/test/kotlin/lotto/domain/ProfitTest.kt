package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.dto.ResultDTO

class ProfitTest:StringSpec({

    "총 수익을 계산한다."{
        Profit.calculateLottoProfit(listOf(
            ResultDTO(3,LottoEnum.THREE),
            ResultDTO(1,LottoEnum.FOUR),
        )) shouldBe 65000
    }

    "총 수익률을 계산한다."{
        Profit.calculateLottoProfitRatio(3000,10000) shouldBe 0.3
    }
})
