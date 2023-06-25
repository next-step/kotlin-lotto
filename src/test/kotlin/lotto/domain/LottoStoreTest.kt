package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import step1.SimpleAddExpressionParser

class LottoStoreTest : StringSpec({
    "Lotto가 1000원일때, 10,000원으로 수동 3개를 구매하는 경우 자동으로 7개가 구매되어 총 10개가 반환된다 " {
        val manualNumbers = listOf(
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44)
        )
        val lottos = LottoStore(1000).buyLottos(10_000, manualNumbers)
        lottos.size shouldBe 10
    }

    "Lotto가 1000원일때, 9,400원으로 수동 5개를 구매하는 경우, 자동으로 4개가 구매되어 총 9개가 반환된다 " {
        val manualNumbers = listOf(
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(7, 11, 16, 35, 36, 44)
        )
        val lottos = LottoStore(1000).buyLottos(9_400, manualNumbers)
        lottos.size shouldBe 9
    }

    "수식에 음수가 포함되어 있을때, RuntimeException을 throw 한다" {
        shouldThrow<RuntimeException> {
            val parser = SimpleAddExpressionParser()
            parser.parse("-1:0:0")
        }
    }

    "Lotto가 1000원일때, 900원으로 수동 5개를 구매하는 경우, IllegalArgumentException이 발생한다" {
        shouldThrow<IllegalArgumentException> {
            val manualNumbers = listOf(
                listOf(8, 21, 23, 41, 42, 43),
                listOf(3, 5, 11, 16, 32, 38),
                listOf(7, 11, 16, 35, 36, 44),
                listOf(7, 11, 16, 35, 36, 44),
                listOf(7, 11, 16, 35, 36, 44)
            )
           LottoStore(1000).buyLottos(900, manualNumbers)
        }
    }

    "Lotto가 1000원일때, 10,000원으로 1,000원 자동으로만 Lotto를 구입할 경우, 10개가 반환된다 " {
        val lottos = LottoStore(1000).buyLottos(10_000)
        lottos.size shouldBe 10
    }

    "Lotto가 1000원일때, 10,900원으로 1,000원 자동으로만 Lotto를 구입할 경우, 10개가 반환된다 " {
        val lottos = LottoStore(1000).buyLottos(10_000)
        lottos.size shouldBe 10
    }

    "Lotto가 1000원일때, 900원으로 1,000원 자동으로만 Lotto를 구입할 경우, 0개가 반환된다 " {
        val lottos = LottoStore(1000).buyLottos(900)
        lottos.size shouldBe 0
    }

    "Lotto가 1000원일때, 0원으로 1,000원 자동으로만 Lotto를 구입할 경우, 0개가 반환된다 " {
        val lottos = LottoStore(1000).buyLottos(0)
        lottos.size shouldBe 0
    }
})
