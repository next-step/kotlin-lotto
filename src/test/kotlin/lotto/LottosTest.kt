package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoStore.buyLotto
import lotto.domain.Lottos

class LottosTest : FunSpec({
    test("구매한 로또 갯수를 확인할 수 있다.") {
        val lottoList = List(3) { buyLotto() }
        val lottos = Lottos(lottoList)
        lottos.getLottoCount() shouldBe lottoList.size
    }
})
