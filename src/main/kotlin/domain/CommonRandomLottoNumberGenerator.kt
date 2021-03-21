package domain

class CommonRandomLottoNumberGenerator : RandomLottoNumberGenerator {
    override fun generate(): LottoNumbers {
        return (1..45).shuffled()
            .take(6)
            .map { LottoNumber(it) }
            .let { LottoNumbers(it) }
    }
}
