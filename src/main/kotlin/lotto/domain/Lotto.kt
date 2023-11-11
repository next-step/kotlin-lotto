package lotto.domain

import lotto.numbermaker.RandomNumberMaker

class Lotto(val number: Int = LOTTO_DEFAULT_NUMBER) {
    private val randomNumberMaker: RandomNumberMaker = RandomNumberMaker()
    val numbers = mutableListOf<LottoNumber>()

    init {
        val randomNumber = randomNumberMaker.generate()
        randomNumber.forEach { it ->
            val lottoNumber = LottoNumber.from(it)
            numbers.add(lottoNumber)
        }
    }

    companion object {
        private const val LOTTO_DEFAULT_NUMBER = 6
    }
}
