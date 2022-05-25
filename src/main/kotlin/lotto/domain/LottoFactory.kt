package lotto.domain

import lotto.model.LottoTicket
import kotlin.random.Random

/**
 * 로또 번호를 자동으로 발급해주는 클래스
 * Created by Jaesungchi on 2022.05.24..
 */
object LottoFactory {
    private const val MIN_LOTTO_NUMBER = 1
    private const val MAX_LOTTO_NUMBER = 45
    private const val LOTTO_SIZE = 6

    fun getRandomLottoTicket(): LottoTicket {
        val numbers = mutableSetOf<Int>()
        while (numbers.size < LOTTO_SIZE) {
            numbers.add(getRandomNumber())
        }
        return LottoTicket(numbers.sorted())
    }

    private fun getRandomNumber() = Random.nextInt(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
}
