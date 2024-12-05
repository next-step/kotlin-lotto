package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.Order
import lotto.domain.Rank
import lotto.domain.WinningLotto

class WinningLottoTest : StringSpec({
    "당첨됨 로또의 개수를 제공한다." {
        val lotto = createLotto(1, 2, 3, 7, 8, 9)
        val order = Order(1000, listOf(lotto))
        val winningLotto = WinningLotto(createLotto(1, 2, 3, 4, 5, 6), LottoNumber.getNumber(7))

        val result = winningLotto.match(order)

        result.count { it == Rank.FIFTH } shouldBe 1
    }
})
