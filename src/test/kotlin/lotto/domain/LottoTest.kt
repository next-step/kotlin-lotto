package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.constants.WinningRank

class LottoTest : BehaviorSpec({

    given("숫자 6개가 주어졌을 때") {
        val numbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        `when`("로또를 생성하면") {
            val lotto = Lotto(numbers)
            then("로또가 생성된다.") {
                lotto.lottoNumbers shouldBe numbers
            }
        }
    }

    given("숫자 5개 주어졌을 때") {
        val numbers = LottoNumbers(listOf(1, 2, 3, 4, 5).map { LottoNumber(it) })
        `when`("로또를 생성하면") {
            val exception = shouldThrow<IllegalArgumentException> {
                Lotto(numbers)
            }
            then("에러가 발생한다.") {
                exception.message shouldBe "로또는 6개의 숫자만 가질 수 있습니다."
            }
        }
    }

    given("로또 번호와 당첨번호가 3개의 값이 동일하게 주어지면") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 7, 8, 9).map { LottoNumber(it) })
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningNumbers, LottoNumber(7))

        `when`("당첨번호와 로또번호를 비교하면") {
            val lottoRank = lotto.winningRank(winningLotto)
            then("3개 일치하고 5등이다.") {
                lottoRank shouldBe WinningRank.FIFTH
                lottoRank.count shouldBe 3
            }
        }
    }

    given("로또 번호와 당첨번호가 4개의 값이 동일하게 주어지면") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 8, 9).map { LottoNumber(it) })
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningNumbers, LottoNumber(7))

        `when`("당첨번호와 로또번호를 비교하면") {
            val lottoRank = lotto.winningRank(winningLotto)
            then("4개 일치하고 4등이다.") {
                lottoRank shouldBe WinningRank.FOURTH
                lottoRank.count shouldBe 4
            }
        }
    }

    given("로또 번호와 당첨번호가 5개의 값이 동일하게 주어지면") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 9).map { LottoNumber(it) })
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningNumbers, LottoNumber(7))

        `when`("당첨번호와 로또번호를 비교하면") {
            val lottoRank = lotto.winningRank(winningLotto)
            then("5개 일치하고 3등이다.") {
                lottoRank shouldBe WinningRank.THIRD
                lottoRank.count shouldBe 5
            }
        }
    }

    given("로또 번호와 당첨번호가 동일하게 주어지고, 보너스 번호가 나머지 하나와 같다면") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 9).map { LottoNumber(it) })
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningNumbers, LottoNumber(9))

        `when`("당첨번호와 로또번호를 비교하면") {
            val lottoRank = lotto.winningRank(winningLotto)
            then("5개 일치하고 보너스 번호가 일치하므로 2등이다.") {
                lottoRank shouldBe WinningRank.SECOND
                lottoRank.count shouldBe 5
                lottoRank.matchBonus shouldBe true
            }
        }
    }

    given("로또 번호와 당첨번호가 모두 동일하게 주어지면") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningNumbers, LottoNumber(7))

        `when`("당첨번호와 로또번호를 비교하면") {
            val lottoRank = lotto.winningRank(winningLotto)
            then("6개 일치하고 1등이다.") {
                lottoRank shouldBe WinningRank.FIRST
                lottoRank.count shouldBe 6
            }
        }
    }
})
