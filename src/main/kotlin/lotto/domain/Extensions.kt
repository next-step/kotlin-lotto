package lotto.domain

fun List<Int>.toLottoNumbers(): LottoNumbers {
    return LottoNumbers(map { LottoNumber(it) })
}
