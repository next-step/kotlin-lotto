package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RankTest : FunSpec({
    context("로또 등수를 확인한다.") {
        context("1등") {
            val rank = Rank.of(6, false)
            rank shouldBe Rank.FIRST
        }

        context("2등") {
            val rank = Rank.of(5, true)
            rank shouldBe Rank.SECOND
        }

        context("3등") {
            val rank = Rank.of(5, false)
            rank shouldBe Rank.THIRD
        }

        context("4등") {
            val rank = Rank.of(4, false)
            rank shouldBe Rank.FOURTH
        }

        context("5등") {
            val rank = Rank.of(3, false)
            rank shouldBe Rank.FIFTH
        }

        context("꽝") {
            val rank = Rank.of(2, false)
            rank shouldBe Rank.MISS
        }
    }
})
