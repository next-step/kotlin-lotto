package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CandidateNumbersTest : BehaviorSpec({
    given("로또 번호가 될 수 있는 숫자의") {
        `when`("총 개수는") {
            then("45개 이다.") {
                CandidateNumbers.getNumbers().size shouldBe MAXIMUM_LOTTO_NUMBER
            }
        }
    }

    given("숫자들 중") {
        `when`("6개의 숫자를 뽑으면") {
            val result = CandidateNumbers.pick()
            then("중복 없이 6개의 숫자를 반환한다.") {
                result.size shouldBe MAXIMUM_LOTTO_NUMBER_SIZE
                result.distinct().size shouldBe MAXIMUM_LOTTO_NUMBER_SIZE
            }
        }
    }
}) {
    companion object {
        private const val MAXIMUM_LOTTO_NUMBER_SIZE = 6
        private const val MAXIMUM_LOTTO_NUMBER = 45
    }
}
