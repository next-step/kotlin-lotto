package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.RewardClassifier
import lotto.domain.RewardType

class RewardClassifierTest : FunSpec({
    test("RewardClassifier가 로또를 올바르게 분류한다") {
        // Given
        val lottoList =
            listOf(
                // FIRST
                LottoStub.get(matchCount = 6),
                LottoStub.get(matchCount = 6),
                // SECOND
                LottoStub.get(matchCount = 5),
                // THIRD
                LottoStub.get(matchCount = 4),
                LottoStub.get(matchCount = 4),
                // FOURTH
                LottoStub.get(matchCount = 3),
                // SIXTH
                LottoStub.get(matchCount = 1),
                // NONE
                LottoStub.get(matchCount = 0),
            )

        // When
        val result = RewardClassifier.classify(lottoList)

        // Then
        result[RewardType.FIRST] shouldBe 2
        result[RewardType.SECOND] shouldBe 1
        result[RewardType.THIRD] shouldBe 2
        result[RewardType.FOURTH] shouldBe 1
        result[RewardType.SIXTH] shouldBe 1
        result[RewardType.NONE] shouldBe 1
        result[RewardType.FITFTH] shouldBe null // 이 경우는 포함되지 않음
    }
})
