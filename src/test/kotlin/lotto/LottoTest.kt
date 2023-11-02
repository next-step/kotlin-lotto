package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import lotto.domain.Lotto
import lotto.domain.LottoStore.buyLotto
import lotto.util.shuffleNumber

class LottoTest : FunSpec({

    test("당첨번호와 로또번호를 비교한다.") {
        val lotto = buyLotto()
        val winningLotto = Lotto(shuffleNumber())

        val matchCount = lotto.matchCount(winningLotto)
        matchCount shouldBeInRange 0..6
    }
})
