package lotto

import lotto.LottoRule.LOTTO_NUMBER_COUNT
import lotto.LottoRule.MAX_NUMBER
import lotto.LottoRule.MIN_NUMBER
import kotlin.random.Random

/**
 * 로또 번호 추출기
 */
object Extractor {
    fun getAutoNumbers(): List<Int> {
        val list = mutableListOf<Int>()
        while (list.size < LOTTO_NUMBER_COUNT) {
            val random = Random.nextInt(MIN_NUMBER, MAX_NUMBER)

            if (!list.contains(random)) {
                list.add(random)
            }
        }
        return list.toList().sorted()
    }
}
