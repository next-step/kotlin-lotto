package lotto.domain

fun getAutoLotto(): Lotto {
    return LottoNumber.ALL.shuffled()
        .let { Lotto(it.subList(0, 6)) }
}
