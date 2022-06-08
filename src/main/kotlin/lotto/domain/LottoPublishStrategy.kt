package lotto.domain

fun generateAutoLotto(): Lotto {
    return LottoNumber.ALL.shuffled()
        .let { Lotto(it.subList(0, 6)) }
}
