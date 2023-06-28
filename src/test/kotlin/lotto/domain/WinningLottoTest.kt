package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : BehaviorSpec({

    given("당첨 번호 [1, 2, 3, 4, 5, 6]") {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        `when`("보너스 번호 6으로 생성 하면") {
            val bonusNumber = LottoNumber(6)
            then("오류가 발생 한다.") {
                shouldThrow<RuntimeException> { WinningLotto(Lotto.from(lottoNumbers), bonusNumber) }
            }
        }
        `when`("보너스 번호 7로 생성 하면") {
            val bonusNumber = LottoNumber(7)
            then("정상적으로 생성 된다.") {
                shouldNotThrow<RuntimeException> { WinningLotto(Lotto.from(lottoNumbers), bonusNumber) }
            }
        }
    }

    given("당첨 번호 [1, 2, 3, 4, 5, 6] / 보너스 7 로 생성 하였을 때") {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val winningLotto = WinningLotto(Lotto.from(lottoNumbers), LottoNumber(7))
        `when`("로또 번호 [1, 2, 3, 4, 5, 6]로 추첨 하면") {
            val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
            then("로또 1등에 당첨 된다.") {
                winningLotto.rank(lotto) shouldBe LottoRank.FIRST
            }
        }
        `when`("로또 번호 [1, 2, 3, 4, 5, 7]로 추첨 하면") {
            val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) })
            then("로또 2등에 당첨 된다.") {
                winningLotto.rank(lotto) shouldBe LottoRank.SECOND
            }
        }
        `when`("로또 번호 [1, 2, 3, 4, 5, 8]로 추첨 하면") {
            val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 8).map { LottoNumber(it) })
            then("로또 3등에 당첨 된다.") {
                winningLotto.rank(lotto) shouldBe LottoRank.THIRD
            }
        }
        `when`("로또 번호 [1, 2, 3, 4, 8, 9]로 추첨 하면") {
            val lotto = Lotto.from(listOf(1, 2, 3, 4, 8, 9).map { LottoNumber(it) })
            then("로또 4등에 당첨 된다.") {
                winningLotto.rank(lotto) shouldBe LottoRank.FOURTH
            }
        }
        `when`("로또 번호 [1, 2, 3, 8, 9, 10]로 추첨 하면") {
            val lotto = Lotto.from(listOf(1, 2, 3, 8, 9, 10).map { LottoNumber(it) })
            then("로또 5등에 당첨 된다.") {
                winningLotto.rank(lotto) shouldBe LottoRank.FIFTH
            }
        }
        `when`("로또 번호 [11, 12, 13, 14, 15, 16]로 추첨 하면") {
            val lotto = Lotto.from(listOf(11, 12, 13, 14, 15, 16).map { LottoNumber(it) })
            then("미 당첨 된다.") {
                winningLotto.rank(lotto) shouldBe LottoRank.UNRANKED
            }
        }
    }
})
