package lotto.util

object KotlinRandomGenerate : RandomGenerate {
    @Throws(IllegalArgumentException::class)
    override fun makeRandomUniqueIntList(takeListSize: Int, randomRange: IntRange): List<Int> {
        require(takeListSize <= randomRange.last - randomRange.first + 1) { "랜덤범위($randomRange)가 가져올 리스트 갯수($takeListSize) 보다 큽니다" }
        return randomRange.shuffled().take(takeListSize)
    }
}
