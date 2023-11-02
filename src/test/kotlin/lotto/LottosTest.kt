package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.Lottos

class LottosTest : FunSpec({
    test("구매한 로또 갯수를 확인할 수 있다.") {
        val lottoList = List(3) { Lotto() }
        val lottos = Lottos(lottoList)
        lottos.getLottoCount() shouldBe lottoList.size
    }
})
