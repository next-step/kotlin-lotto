package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.model.vo.MatchCount

/**
 * 로또 번호 맞춘 횟수 테스트
 * */
class MatchCountTest : FunSpec({

    test("로또 번호 맞춘 횟수 생성시 `-100`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            MatchCount.valueOf(-100)
        }
    }

    test("로또 번호 맞춘 횟수 생성시 `-1`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            MatchCount.valueOf(-1)
        }
    }

    test("로또 번호 맞춘 횟수 생성시 `7`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            MatchCount.valueOf(7)
        }
    }

    test("로또 번호 맞춘 횟수 생성시 `1`을 넣을 경우 `1`을 가지고 있는 로또 번호 맞춘 횟수가 생성 되어야 한다.") {
        val matchCount = MatchCount.valueOf(1)
        matchCount.matchCount shouldBe 1
    }

    test("로또 번호 맞춘 횟수 생성시 `3`을 넣을 경우 `3`을 가지고 있는 로또 번호 맞춘 횟수가 생성 되어야 한다.") {
        val matchCount = MatchCount.valueOf(3)
        matchCount.matchCount shouldBe 3
    }

    test("로또 번호 맞춘 횟수 생성시 `6`을 넣을 경우 `6`을 가지고 있는 로또 번호 맞춘 횟수가 생성 되어야 한다.") {
        val matchCount = MatchCount.valueOf(6)
        matchCount.matchCount shouldBe 6
    }
})
