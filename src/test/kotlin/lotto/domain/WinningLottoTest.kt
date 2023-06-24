package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : BehaviorSpec({

    given("당첨 번호 [1, 2, 3, 4, 5, 6]로 생성 하였을 때") {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val winningLotto = WinningLotto(Lotto.of(lottoNumbers))
        `when`("로또 번호 [1, 2, 3, 4, 5, 6]로 추첨 하면") {
            val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
            then("로또 1등에 당첨 된다.") {
                winningLotto.rank(lotto) shouldBe LottoRank.FIRST
            }
        }
        `when`("로또 번호 [1, 2, 3, 4, 5, 7]로 추첨 하면") {
            val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) })
            then("로또 2등에 당첨 된다.") {
                winningLotto.rank(lotto) shouldBe LottoRank.SECOND
            }
        }
        `when`("로또 번호 [1, 2, 3, 4, 8, 7]로 추첨 하면") {
            val lotto = Lotto.of(listOf(1, 2, 3, 4, 8, 7).map { LottoNumber(it) })
            then("로또 3등에 당첨 된다.") {
                winningLotto.rank(lotto) shouldBe LottoRank.THIRD
            }
        }
        `when`("로또 번호 [7, 8, 9, 10, 11, 12]로 추첨 하면") {
            val lotto = Lotto.of(listOf(7, 8, 9, 10, 11, 12).map { LottoNumber(it) })
            then("미 당첨 된다.") {
                winningLotto.rank(lotto) shouldBe LottoRank.UNRANKED
            }
        }
    }
})
