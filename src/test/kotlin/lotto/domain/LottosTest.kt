package lotto.domain

import io.kotest.core.spec.style.StringSpec
import org.junit.jupiter.api.Assertions.*

class LottosTest : StringSpec({

    "로또를 병합한다" {
        val lottos = Lottos(listOf(Lotto(setOf(1, 2, 3, 4, 5, 6))))
        val otherLottos = Lottos(listOf(Lotto(setOf(1, 2, 3, 4, 5, 6))))
        assertEquals(2, lottos.merge(otherLottos).size)
    }

    "로또를 매칭시켜 순위 조회" {
        val lottos = Lottos(listOf(Lotto(setOf(1, 2, 3, 4, 5, 6))))
        val winningLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val bonusBall = 7
        assertEquals(Ranks(listOf(Rank.FIRST)), lottos.match(winningLotto, bonusBall))
    }

    "로또 타입별 갯수 확인" {
        val lottos = Lottos(listOf(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 3, 4, 5, 6), LottoType.MANUAL)))
        assertEquals(1, lottos.getCount(LottoType.AUTO))
        assertEquals(1, lottos.getCount(LottoType.MANUAL))
    }
})
