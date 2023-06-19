package lotto.domain

object LottoNumberSupports {

    fun IntRange.toLottoNumbers(): List<LottoNumber> {
        return this.map { LottoNumber.of(it) }
    }

    fun List<Int>.toLottoNumbers(): List<LottoNumber> {
        return this.map { LottoNumber.of(it) }
    }
}
