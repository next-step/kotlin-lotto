package lotto.step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.maps.shouldContainExactly
import io.kotest.matchers.shouldBe
import lotto.step4.domain.LottoNumber
import lotto.step4.domain.Lottos
import lotto.step4.domain.Rank

class LottosTest : FunSpec({
    val lotto1 = LottoStub.get(listOf(1, 2, 3, 4, 5, 6))
    val lotto2 = LottoStub.get(listOf(7, 8, 9, 10, 11, 12))
    val lotto3 = LottoStub.get(listOf(1, 2, 3, 4, 5, 7))

    val lottos1 = Lottos(listOf(lotto1, lotto2))
    val lottos2 = Lottos(listOf(lotto3))

    test("size()는 Lottos의 크기를 반환해야 한다") {
        lottos1.size() shouldBe 2
        lottos2.size() shouldBe 1
    }

    test("getAll()은 Lottos의 모든 로또를 반환해야 한다") {
        lottos1.getAll() shouldContainExactly listOf(lotto1, lotto2)
        lottos2.getAll() shouldContainExactly listOf(lotto3)
    }

    test("add()는 두 Lottos를 합쳐 새로운 Lottos를 반환해야 한다") {
        val combinedLottos = lottos1.add(lottos2)
        combinedLottos.getAll() shouldContainExactly listOf(lotto1, lotto2, lotto3)
        combinedLottos.size() shouldBe 3
    }

    test("matchWinningNumbers()는 각 Rank에 해당하는 로또 개수를 계산해야 한다") {
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()
        val bonusNumber = LottoNumber(7)

        val ranks1 = lottos1.matchWinningNumbers(winningNumbers, bonusNumber)

        ranks1.asMap() shouldContainExactly
            mapOf(
                // lotto1은 6개 일치
                Rank.FIRST to 1L,
                // lotto2는 아무것도 일치하지 않음
                Rank.MISS to 1L,
            )

        val ranks2 = lottos2.matchWinningNumbers(winningNumbers, bonusNumber)

        ranks2.asMap() shouldContainExactly
            mapOf(
                // lotto3은 5개 + 보너스 번호 일치
                Rank.SECOND to 1L,
            )
    }
})
