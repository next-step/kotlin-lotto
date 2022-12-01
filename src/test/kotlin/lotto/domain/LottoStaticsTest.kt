package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.nextDown
import kotlin.math.round
import kotlin.math.roundToLong
import kotlin.math.truncate
import kotlin.math.ulp

internal class LottoStaticsTest {

    @DisplayName("구매 금액과 당첨금을 비교해서 수익률을 계산한다")
    @Test
    fun bep() {
        val amount = 14_000
        val prize = 5_000

        val result = LottoStatics().calculateEarningRate(prize, amount)

        val a: Int = prize.floorDiv(amount)
        println(">>>> a = $a")

        result shouldBe 0.35
    }
}
