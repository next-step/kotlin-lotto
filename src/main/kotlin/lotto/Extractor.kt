package lotto

import kotlin.random.Random

/**
 * 로또 번호 추출기
 */
object Extractor {

    val randomNumberFunc = {
        val list = mutableListOf<Int>()
        while (list.size < LottoRule.LOTTO_NUMBER_COUNT) {
            val random = Random.nextInt(LottoRule.MIN_NUMBER, LottoRule.MAX_NUMBER)

            if (!list.contains(random)) {
                list.add(random)
            }
        }

        list.sorted().map { LottoNumber(it) }
    }
}
