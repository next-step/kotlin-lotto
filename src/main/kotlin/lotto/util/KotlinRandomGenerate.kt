package lotto.util

object KotlinRandomGenerate : RandomGenerate {
    override fun makeRandomUniqueIntList(listSize: Int, randomRange: IntRange): List<Int> {
        return randomRange.shuffled().take(listSize)
    }
}
