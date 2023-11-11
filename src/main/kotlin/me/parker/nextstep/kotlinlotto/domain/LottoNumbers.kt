package me.parker.nextstep.kotlinlotto.domain

class LottoNumbers {
    val values: MutableSet<LottoNumber> = mutableSetOf()

    fun add(lottoNumber: LottoNumber) {
        values.add(lottoNumber)
    }
}
