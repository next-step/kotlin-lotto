package lottery.domain

class InputNumberGenerator(private val userLottoNumbers: List<Int>) : LottoNumberGenerator {

    override fun getNumbers(): List<Int> {
        return userLottoNumbers
    }
}
