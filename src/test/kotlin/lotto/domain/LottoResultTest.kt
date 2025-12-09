package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : FreeSpec({
    "로또 당첨 결과 및 수익률 테스트" - {
        val winLotto =
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                ),
            )
        val bonusBall = BonusBall(winLotto, LottoNumber(7))

        "당첨된 숫자가 하나도 없는 경우 MISS 1개 나오고 수익률은 0 이다." {
            val lottoTicket =
                LottoTicket(
                    Money(1000),
                    listOf(
                        Lotto(
                            listOf(
                                LottoNumber(7),
                                LottoNumber(8),
                                LottoNumber(9),
                                LottoNumber(10),
                                LottoNumber(11),
                                LottoNumber(12),
                            ),
                        ),
                    ),
                    emptyList(),
                )

            // when
            val lottoResult = LottoResult(winLotto, bonusBall, lottoTicket)

            // then
            lottoResult.matchMap shouldBe mapOf(Pair(Rank.MISS, 1))
            lottoResult.rateOfReturn shouldBe 0.0
        }

        "1등에 당첨된 경우 FIRST 1개 나오고 수익률은 2000000.0 이다" {
            val lottoTicket =
                LottoTicket(
                    Money(1000),
                    listOf(
                        Lotto(
                            listOf(
                                LottoNumber(1),
                                LottoNumber(2),
                                LottoNumber(3),
                                LottoNumber(4),
                                LottoNumber(5),
                                LottoNumber(6),
                            ),
                        ),
                    ),
                    emptyList(),
                )

            // when
            val lottoResult = LottoResult(winLotto, bonusBall, lottoTicket)

            // then
            lottoResult.matchMap shouldBe mapOf(Pair(Rank.FIRST, 1))
            lottoResult.rateOfReturn shouldBe 2000000.0
        }

        "1등에 당첨되었고, 로또를 2장 산 경우 FIRST 1개, MISS 1개 나오고 수익률은 1000000.0 이다" {
            val lottoTicket =
                LottoTicket(
                    Money(2000),
                    listOf(
                        Lotto(
                            listOf(
                                LottoNumber(1),
                                LottoNumber(2),
                                LottoNumber(3),
                                LottoNumber(4),
                                LottoNumber(5),
                                LottoNumber(6),
                            ),
                        ),
                        Lotto(
                            listOf(
                                LottoNumber(2),
                                LottoNumber(5),
                                LottoNumber(10),
                                LottoNumber(11),
                                LottoNumber(12),
                                LottoNumber(13),
                            ),
                        ),
                    ),
                    emptyList(),
                )

            // when
            val lottoResult = LottoResult(winLotto, bonusBall, lottoTicket)

            // then
            lottoResult.matchMap shouldBe mapOf(Pair(Rank.FIRST, 1), Pair(Rank.MISS, 1))
            lottoResult.rateOfReturn shouldBe 1000000.0
        }
    }
})
