package lotto.domain

class FakeLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        return Lotto(fakeLottoNumbers)
    }

    companion object {
        val fakeLottoNumbers = (11..16).map(::LottoNumber)
    }
}
