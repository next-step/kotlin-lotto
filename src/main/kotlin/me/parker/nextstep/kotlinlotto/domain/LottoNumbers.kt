package me.parker.nextstep.kotlinlotto.domain

class LottoNumbers {
    val values: MutableList<LottoNumber> = mutableListOf()

    fun add(lottoNumber: LottoNumber) {
        if (values.contains(lottoNumber)) {
            return
        }

        values.add(lottoNumber)
    }
}