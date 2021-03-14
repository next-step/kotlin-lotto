package lotto.domain

fun createLotto(num1: Int, num2: Int, num3: Int, num4: Int, num5: Int, num6: Int) =
    listOf(
        LottoNumber(num1),
        LottoNumber(num2),
        LottoNumber(num3),
        LottoNumber(num4),
        LottoNumber(num5),
        LottoNumber(num6),
    )
