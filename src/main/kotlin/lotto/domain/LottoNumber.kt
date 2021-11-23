package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in LottoNumberFactory.NUMBER_FROM..LottoNumberFactory.NUMBER_TO)
        { "로또 번호는 ${LottoNumberFactory.NUMBER_FROM}부터 ${LottoNumberFactory.NUMBER_TO} 사이의 숫자만 가능합니다." }
    }
}


