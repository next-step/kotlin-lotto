package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoTest : BehaviorSpec({
    given("로또 번호를 생성할 때") {
        `when`("자동으로 생성되도록 한다면") {
            val result = Lotto.createRandom()

            then("중복없는 6개의 로또 번호를 생성한다.") {
                result.lottoNumbers.distinct().size shouldBe 6
            }
        }

        `when`("6개가 아니라면") {
            val lottoNumbers = (
                listOf(
                    LottoNumber(2),
                    LottoNumber(33),
                    LottoNumber(34),
                    LottoNumber(35),
                    LottoNumber(36),
                    LottoNumber(37),
                    LottoNumber(38),
                )
                )
            then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    Lotto(lottoNumbers.toSet())
                }
            }
        }

        `when`("중복이 있다면") {
            val lottoNumbers = (
                listOf(
                    LottoNumber(2),
                    LottoNumber(33),
                    LottoNumber(33),
                    LottoNumber(33),
                    LottoNumber(33),
                    LottoNumber(33),
                )
                )
            then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    Lotto(lottoNumbers.toSet())
                }
            }
        }
    }

    given("당첨 번호와 구입한 로또의 일치하는 수의 개수를 구할 때") {
        val winningLottoNumbers = Lotto(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        `when`("3개가 일치한다면") {
            val purchasedLottoNumbers = Lotto(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(33),
                    LottoNumber(34),
                    LottoNumber(35)
                )
            )
            then("일치하는 수 3을 반환한다.") {
                val result = winningLottoNumbers.getNumberOfMatch(purchasedLottoNumbers)
                result shouldBe 3
            }
        }
    }

    given("로또 번호들과 당첨 번호를 비교할 때") {
        val lottoNumbers = Lotto(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )

        `when`("보너스 볼의 숫자와 일치한다면") {
            val bonusBall = LottoNumber(1)
            val result = lottoNumbers.isMatchBonusLottoNumber(bonusBall)

            then("true 를 반환한다.") {
                result shouldBe true
            }
        }
    }
})
