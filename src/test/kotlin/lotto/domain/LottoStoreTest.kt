package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : StringSpec({
    "10,000원으로 1,000원 Lottot를 구입할 경우, 10개가 반환된다 " {
        val lottos = LottoStore(1000).buyLottos(10_000)
        lottos.size shouldBe 10
    }

    "10,900원으로 1,000원 Lottot를 구입할 경우, 10개가 반환된다 " {
        val lottos = LottoStore(1000).buyLottos(10_000)
        lottos.size shouldBe 10
    }

    "900원으로 1,000원 Lottot를 구입할 경우, 0개가 반환된다 " {
        val lottos = LottoStore(1000).buyLottos(900)
        lottos.size shouldBe 0
    }

    "0원으로 1,000원 Lottot를 구입할 경우, 0개가 반환된다 " {
        val lottos = LottoStore(1000).buyLottos(0)
        lottos.size shouldBe 0
    }

    "구매한 Lotto의 숫자들이 중복되지 않는다" {
        val lottos = LottoStore(1).buyLottos(10_000)
        for (lotto in lottos) {
            val hasDuplicates = lotto.pickedNumbers.stream()
                .distinct()
                .count() < lotto.pickedNumbers.size
            hasDuplicates shouldBe false
        }
    }
})
