package com.example.mylotto.model

import com.example.mylotto.enum.Rank
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoResultTest :
    BehaviorSpec({
        given("a list of ranks") {
            val ranks = listOf(Rank.FIRST, Rank.THIRD, Rank.THIRD, Rank.THIRD)

            `when`("a LottoResult is created") {
                val lottoResult = LottoResult.of(ranks)

                then("the rank count map should correctly group counts") {
                    val rankCounts = lottoResult.rankCountMap

                    rankCounts[Rank.FIRST].shouldBe(1)
                    rankCounts[Rank.THIRD].shouldBe(3)
                    rankCounts[Rank.FOURTH].shouldBe(null)
                }
            }
        }
    })
