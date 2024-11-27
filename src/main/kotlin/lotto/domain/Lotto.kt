package lotto.domain

class Lotto {
    companion object {
        fun generate(): Set<LottoNumber> {
            return setOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
            )
        }
    }
}
