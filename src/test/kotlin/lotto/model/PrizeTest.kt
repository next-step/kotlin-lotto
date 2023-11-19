package lotto.model

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PrizeTest {
    @ParameterizedTest()
    @MethodSource("provideGetKeyWithMatchedTestParam")
    fun getKeyWithMatchedTest(args: List<Any>) {
        val matched = args[0] as Int
        val bonusNumberMatched = args[1] as Boolean
        val expectedKey = args[2] as Prize

        val key = Prize.getKeyWithMatched(matched, bonusNumberMatched)
        key shouldBe expectedKey
    }

    companion object {
        @JvmStatic
        fun provideGetKeyWithMatchedTestParam() = listOf(
            listOf(6, false, Prize.FIRST),
            listOf(5, true, Prize.SECOND),
            listOf(5, false, Prize.THIRD),
        )

        @JvmStatic
        fun provideIsBonusTestParam() = listOf(
            listOf(6, false, false),
            listOf(5, true, true),
            listOf(2, true, false),
        )
    }
}

