package lotto

import kotlin.random.Random

class RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): LottoNumber {
        val targetNumber = Random.nextInt(LottoNumber.cache.size) + 1
        return LottoNumber.cache[targetNumber]
            ?: throw IllegalArgumentException("캐시가 비어있습니다. $targetNumber")
    }
}
