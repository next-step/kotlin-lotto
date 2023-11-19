package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoGameTest : FunSpec({
    context("로또 게임은") {
        val lottoList = listOf(
            LottoNumbers(
                setOf(
                    LottoNumber(1),
                    LottoNumber(15),
                    LottoNumber(20),
                    LottoNumber(27),
                    LottoNumber(30),
                    LottoNumber(36)
                )
            ),
            LottoNumbers(
                setOf(
                    LottoNumber(10),
                    LottoNumber(16),
                    LottoNumber(20),
                    LottoNumber(25),
                    LottoNumber(30),
                    LottoNumber(40)
                )
            ),
            LottoNumbers(
                setOf(
                    LottoNumber(11),
                    LottoNumber(12),
                    LottoNumber(13),
                    LottoNumber(14),
                    LottoNumber(15),
                    LottoNumber(16)
                )
            ),
            LottoNumbers(
                setOf(
                    LottoNumber(10),
                    LottoNumber(15),
                    LottoNumber(20),
                    LottoNumber(25),
                    LottoNumber(30),
                    LottoNumber(40)
                )
            ),
            LottoNumbers(
                setOf(
                    LottoNumber(10),
                    LottoNumber(15),
                    LottoNumber(20),
                    LottoNumber(25),
                    LottoNumber(30),
                    LottoNumber(13)
                )
            ),
            LottoNumbers(
                setOf(
                    LottoNumber(10),
                    LottoNumber(15),
                    LottoNumber(20),
                    LottoNumber(25),
                    LottoNumber(30),
                    LottoNumber(35)
                )
            ),
        )
        val lottoGame = LottoGame(lottoList)
        val winningNumbers = WinningNumbers(
            LottoNumbers(
                setOf(
                    LottoNumber(10),
                    LottoNumber(15),
                    LottoNumber(20),
                    LottoNumber(25),
                    LottoNumber(30),
                    LottoNumber(35)
                )
            ), LottoNumber(13)
        )

        test("N개의 로또를 가진다.") {
            lottoGame.lottoList.size shouldBe 6
        }

        test("3-6개 일치 로또의 개수를 계산할 수 있다.") {
            val expected = LottoGameResult(
                totalPrice = 6000,
                rewards = listOf(
                    LottoReward.FIRST,
                    LottoReward.SECOND,
                    LottoReward.THIRD,
                    LottoReward.FOURTH,
                    LottoReward.FIFTH
                )
            )
            lottoGame.getResult(winningNumbers) shouldBe expected
        }

        test("로또 게임은 총 수익률을 계산할 수 있다.") {
            lottoGame.getResult(winningNumbers).calculatePerformance() shouldBe 338592.5
        }
    }

    context("로또 게임의 2등 인원을 찾아낼 수 있다.") {
        val lottoGame = LottoGame(
            listOf(
                LottoNumbers(
                    setOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6)
                    )
                )
            )
        )
        val winningNumbers = WinningNumbers(
            LottoNumbers(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(10)
                )
            ), LottoNumber(6)
        )
        val lottoGameResult = lottoGame.getResult(winningNumbers)
        lottoGameResult.rewards[0] shouldBe LottoReward.SECOND
    }
})
