package step2

class AutoLotto {
    fun generateNumbers(money: Int): List<LottoNumber> {
        val lottoCount = LottoPrice.getCountFrom(money)
        return issueLottoNumbers(lottoCount)
    }

    private fun issueLottoNumbers(count: Int): List<LottoNumber> {
        val lottoNumbers = mutableListOf<LottoNumber>()
        repeat(count) {
            lottoNumbers.add(LottoNumber.buildAuto())
        }

        return lottoNumbers
    }
}
