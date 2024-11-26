package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Order
import lotto.domain.Rank
import lotto.domain.WinningLotto
import lotto.service.LottoCreator
import lotto.service.WinningLottoService

class WinningLottoServiceTest : StringSpec({
    "입력된 숫자를 가진 당첨 로또를 생성할 수 있다." {
        val lottoCreator = LottoCreator(FixedNumberGenerator())

        val result = lottoCreator.createWinningLotto(FixedNumberGenerator().generate(), 7)

        result.winningNumbers shouldBe Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet())
        result.bonusNumber shouldBe LottoNumber(7)
    }

    "각 등수에 대해 각각 몇개씩 일치하는지 정보를 제공한다." {
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
        val winNumbers = WinningLotto(Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet()), LottoNumber(7))

        val result = winningLottoService.checkAndGetResult(order, winNumbers)

        assertSoftly {
            result.winningMatchCounts[0].rank shouldBe Rank.FIFTH
            result.winningMatchCounts[0].totalCount shouldBe 1

            result.winningMatchCounts[1].rank shouldBe Rank.FOURTH
            result.winningMatchCounts[1].totalCount shouldBe 0

            result.winningMatchCounts[2].rank shouldBe Rank.THIRD
            result.winningMatchCounts[2].totalCount shouldBe 0

            result.winningMatchCounts[3].rank shouldBe Rank.SECOND
            result.winningMatchCounts[3].totalCount shouldBe 0

            result.winningMatchCounts[4].rank shouldBe Rank.FIRST
            result.winningMatchCounts[4].totalCount shouldBe 0
        }
    }

    "수익을 제공한다." {
        val winningLottoService = WinningLottoService()
        val order = Order(1000, listOf(Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet())))
        val winNumbers = WinningLotto(Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet()), LottoNumber(7))

        val result = winningLottoService.checkAndGetResult(order, winNumbers)

        result.revenue shouldBe 2_000_000_000
    }

    "수익률을 제공한다." {
        val winningLottoService = WinningLottoService()
        val order = Order(1000, listOf(Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet())))
        val winNumbers = WinningLotto(Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet()), LottoNumber(7))

        val result = winningLottoService.checkAndGetResult(order, winNumbers)

        result.rate shouldBe 2000000.0
    }
})
