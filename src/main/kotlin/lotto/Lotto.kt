package lotto

class Lotto(lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {

    val number: List<Int> = lottoNumberGenerator.pick()

    fun grade(winningNumber: List<Int>): LottoGrade {
        val intersect = number.intersect(winningNumber.toSet())
        return LottoGrade.find(intersect.size) ?: throw IllegalArgumentException("당첨등급을 찾을 수 없습니다")
    }
}
