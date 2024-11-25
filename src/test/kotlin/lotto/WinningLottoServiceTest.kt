package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Order
import lotto.domain.WinningLotto
import lotto.service.WinningLottoService

class WinningLottoServiceTest : StringSpec({
    "3개, 4개, 5개, 6개 에 대해 각각 몇개씩 일치하는지 정보를 제공한다." {
        val lotto =
            Lotto(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(7),
                    LottoNumber(8),
                    LottoNumber(9),
                ),
            )
        val winningLottoService = WinningLottoService()
        val order = Order(1000, listOf(lotto))
        val winNumbers = WinningLotto(Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet()))

        val result = winningLottoService.checkAndGetResult(order, winNumbers)

        assertSoftly {
            result.winningMatchCounts[0].totalCount shouldBe 1
            result.winningMatchCounts[1].totalCount shouldBe 0
            result.winningMatchCounts[2].totalCount shouldBe 0
            result.winningMatchCounts[3].totalCount shouldBe 0
        }
    }

    "수익을 제공한다." {
        val winningLottoService = WinningLottoService()
        val order = Order(1000, listOf(Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet())))
        val winNumbers = WinningLotto(Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet()))

        val result = winningLottoService.checkAndGetResult(order, winNumbers)

        result.revenue shouldBe 2_000_000_000
    }

    "수익률을 제공한다." {
        val winningLottoService = WinningLottoService()
        val order = Order(1000, listOf(Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet())))
        val winNumbers = WinningLotto(Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet()))

        val result = winningLottoService.checkAndGetResult(order, winNumbers)

        result.rate shouldBe 2000000.0
    }
})
