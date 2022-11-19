package lotto.model

class Lotto(lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {

    val number: List<Int> = lottoNumberGenerator.pick()
    lateinit var grade: LottoGrade
        private set

    fun scratch(winningNumber: List<Int>) {
        val intersect = number.intersect(winningNumber.toSet())
        grade = LottoGrade.find(intersect.size)
    }
}
