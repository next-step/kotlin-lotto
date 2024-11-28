package study.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.lotto.model.Lotto

/**
 * @author 이상준
 */
class LottoTest : StringSpec({
    "로또 당첨 매칭 테스트 3개 일치" {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winLotto = Lotto(setOf(1, 2, 3, 7, 8, 9))

        lotto.matchLotto(winLotto) shouldBe 3
    }
    "로또 당첨 매칭 테스트 4개 일치" {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winLotto = Lotto(setOf(1, 2, 3, 4, 8, 9))

        lotto.matchLotto(winLotto) shouldBe 4
    }
    "로또 당첨 매칭 테스트 5개 일치" {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winLotto = Lotto(setOf(1, 2, 3, 4, 5, 9))

        lotto.matchLotto(winLotto) shouldBe 5
    }
    "로또 당첨 매칭 테스트 6개 일치" {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))

        lotto.matchLotto(winLotto) shouldBe 6
    }
    "로또 당첨 매칭 테스트 불일치" {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winLotto = Lotto(setOf(7, 8, 9, 10, 11, 12))

        lotto.matchLotto(winLotto) shouldBe 0
    }
    "로또 보너스볼 매칭 테스트" {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val bonus = 3

        lotto.ishBonus(bonus) shouldBe true
    }
    "로또 보너스볼 매칭 불일치 테스트" {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val bonus = 7

        lotto.ishBonus(bonus) shouldBe false
    }
})
